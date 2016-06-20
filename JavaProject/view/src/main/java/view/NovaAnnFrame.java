package view;

import java.awt.Dimension;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import contract.INovaAnnFrame;
import contract.INovaAnnPlay;
import contract.INovaAnnView;
import contract.INovaAnnWorld;


public class NovaAnnFrame extends JFrame implements KeyListener, INovaAnnFrame {
	private final Point position = new Point(10,7);
	private static final long				serialVersionUID	= 1500600853286674118L;
	private final NovaAnnBoardPanel	mapPanel;
	private NovaAnnBoardPanel				meetingPanel;
	private final INovaAnnPlay		novaAnnPlay;
	private final NovaAnnCardView		novaAnnCardView;

	public NovaAnnFrame(final String title, final INovaAnnWorld novaAnnWorld, final INovaAnnPlay iNovaAnnPlay) {
		this.setTitle(title);
		this.setSize(1000, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.novaAnnPlay = iNovaAnnPlay;
		this.mapPanel = new NovaAnnBoardPanel(new Dimension(novaAnnWorld.getWidth(), novaAnnWorld.getHeight()), novaAnnWorld.getElements(), novaAnnWorld.getMobilesM(),
				this.position, NovaAnnView.MAP_ZOOM);
		this.setResizable(false);
		novaAnnWorld.addObserver(this.mapPanel);
		this.addKeyListener(this);
		this.novaAnnCardView = new NovaAnnCardView();
		this.getContentPane().setLayout(this.novaAnnCardView);
		this.getContentPane().add(this.mapPanel, "MAP");
		this.setVisible(true);
	}

	private INovaAnnPlay getNovaAnnPlay() {
		return this.novaAnnPlay;
	}

	public void setMeeting(final INovaAnnWorld novaAnnWorld) {
		if (this.meetingPanel != null) {
			this.novaAnnCardView.removeLayoutComponent(this.meetingPanel);
		}
		this.meetingPanel = new NovaAnnBoardPanel(new Dimension(novaAnnWorld.getWidth(), novaAnnWorld.getHeight()), novaAnnWorld.getElements(),
				novaAnnWorld.getMobiles(), novaAnnWorld.getHero().getPosition(), NovaAnnView.MEETING_ZOOM);
		novaAnnWorld.addObserver(this.meetingPanel);
		this.getContentPane().add(this.meetingPanel, "MEETING");
	}

	public void refresh(final Point center) {
		this.mapPanel.setCenter(center);
	}


	public void setViewMode(final int viewMode) {
		switch (viewMode) {
		case INovaAnnView.VIEW_MODE_MEETING:
			this.novaAnnCardView.show(this.getContentPane(), "MEETING");
			break;
		case INovaAnnView.VIEW_MODE_MAP:
			this.novaAnnCardView.show(this.getContentPane(), "MAP");
			break;
		default:
			break;
		}
	}


	public void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getNovaAnnPlay().orderPerform(NovaAnnView.keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void keyReleased(final KeyEvent arg0) {
	}


	public void keyTyped(final KeyEvent arg0) {
	}
}
