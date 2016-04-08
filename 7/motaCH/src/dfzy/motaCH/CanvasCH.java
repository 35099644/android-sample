package dfzy.motaCH;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class CanvasCH extends View implements Runnable
{
	private String	m_Tag	= "ThreadCanvas_Tag";


	public CanvasCH(Context context)
	{
		super(context);
	}


	/**
	 * 绘图
	 * 
	 * @param N
	 *            /A
	 * 
	 * @return null
	 */
	protected void onDraw(Canvas canvas)
	{
		if (MainCH.getMainView() != null)
		{
			MainCH.getMainView().onDraw(canvas);
		}
		else
		{
			Log.i(m_Tag, "null");
		}
	}


	/**
	 * 绘图显示
	 * 
	 */
	public void start()
	{
		Thread t = new Thread(this);
		t.start();
	}


	// 刷新界面
	public void refurbish()
	{
		if (MainCH.getMainView() != null)
		{
			MainCH.getMainView().refurbish();
		}
	}


	/**
	 * 游戏循环
	 * 
	 * @param N
	 *            /A
	 * 
	 * @return null
	 */
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(yaCH.GAME_LOOP);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			refurbish(); // 更新显示
			postInvalidate(); // 刷新屏幕
		}
	}


	// 按键处理(按键按下)
	boolean onKeyDown(int keyCode)
	{
		if (MainCH.getMainView() != null)
		{
			MainCH.getMainView().onKeyDown(keyCode);
		}
		else
		{
			Log.i(m_Tag, "null");
		}
		return true;
	}


	// 按键弹起
	boolean onKeyUp(int keyCode)
	{
		if (MainCH.getMainView() != null)
		{
			MainCH.getMainView().onKeyUp(keyCode);
		}
		else
		{
			Log.i(m_Tag, "null");
		}
		return true;
	}
}
