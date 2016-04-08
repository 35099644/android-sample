package dfzy.motaCH;

import android.app.Activity;
import android.content.Context;

public class MainCH
{
	private static ViewCH	m_GameView		= null;		// ��ǰ��Ҫ��ʾ�Ķ���
	private Context				m_Context		= null;
	private MagicCH			m_MagicTower	= null;
	private int 				m_status		= -1;		//��Ϸ״̬
	public  PlayerCH mCMIDIPlayer;
	public byte mbMusic = 0;
	public MainCH(Context context)
	{	
		m_Context = context;
		m_MagicTower = (MagicCH)context;
		m_status = -1;
		
		initGame();
	}
	
	//��ʼ����Ϸ
	public void initGame()
	{
		controlView(yaCH.GAME_SPLASH);
		mCMIDIPlayer = new PlayerCH(m_MagicTower);
	}
	//�õ���Ϸ״̬
	public int getStatus()
	{
		return m_status;
	}
	//������Ϸ״̬
	public void setStatus(int status)
	{
		m_status = status;
	}
	//�õ��������
	public Activity getMagicTower()
	{
		return m_MagicTower;
	}
	
	//�õ���ǰ��Ҫ��ʾ�Ķ���
	public static ViewCH getMainView() 
	{
	    return m_GameView;
	}
	
	//������ʾʲô����
	public void controlView(int status)
	{
		if(m_status != status)
		{
			if(m_GameView != null)
			{
				m_GameView.reCycle();
				System.gc();				
			}
		}
		freeGameView(m_GameView);
		switch (status)
		{
		case yaCH.GAME_SPLASH:
			m_GameView = new SplashCH(m_Context,this);
			break;
		case yaCH.GAME_MENU:
			m_GameView = new MenuCH(m_Context,this);
			break;
		case yaCH.GAME_HELP:
			m_GameView = new HelpScreen(m_Context,this);
			break;
		case yaCH.GAME_ABOUT:
			m_GameView = new AboutCH(m_Context,this);
			break;
		case yaCH.GAME_RUN:
			m_GameView = new ScreenCH(m_Context,m_MagicTower,this,true);
			break;
		case yaCH.GAME_CONTINUE:
			m_GameView = new ScreenCH(m_Context,m_MagicTower,this,false);
			break;
		}
		setStatus(status);
	}
	
	//�ͷŽ������
	public void freeGameView(ViewCH gameView)
	{
		if(gameView != null)
		{
			gameView = null;
			System.gc();
		}
	}
}

