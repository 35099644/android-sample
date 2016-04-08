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
	 * ��ͼ
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
	 * ��ͼ��ʾ
	 * 
	 */
	public void start()
	{
		Thread t = new Thread(this);
		t.start();
	}


	// ˢ�½���
	public void refurbish()
	{
		if (MainCH.getMainView() != null)
		{
			MainCH.getMainView().refurbish();
		}
	}


	/**
	 * ��Ϸѭ��
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

			refurbish(); // ������ʾ
			postInvalidate(); // ˢ����Ļ
		}
	}


	// ��������(��������)
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


	// ��������
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
