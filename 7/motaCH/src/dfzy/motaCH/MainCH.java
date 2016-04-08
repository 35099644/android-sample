package dfzy.motaCH;

import android.app.Activity;
import android.content.Context;

public class MainCH
{
	private static ViewCH	m_GameView		= null;		// 当前需要显示的对象
	private Context				m_Context		= null;
	private MagicCH			m_MagicTower	= null;
	private int 				m_status		= -1;		//游戏状态
	public  PlayerCH mCMIDIPlayer;
	public byte mbMusic = 0;
	public MainCH(Context context)
	{	
		m_Context = context;
		m_MagicTower = (MagicCH)context;
		m_status = -1;
		
		initGame();
	}
	
	//初始化游戏
	public void initGame()
	{
		controlView(yaCH.GAME_SPLASH);
		mCMIDIPlayer = new PlayerCH(m_MagicTower);
	}
	//得到游戏状态
	public int getStatus()
	{
		return m_status;
	}
	//设置游戏状态
	public void setStatus(int status)
	{
		m_status = status;
	}
	//得到主类对象
	public Activity getMagicTower()
	{
		return m_MagicTower;
	}
	
	//得到当前需要显示的对象
	public static ViewCH getMainView() 
	{
	    return m_GameView;
	}
	
	//控制显示什么界面
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
	
	//释放界面对象
	public void freeGameView(ViewCH gameView)
	{
		if(gameView != null)
		{
			gameView = null;
			System.gc();
		}
	}
}

