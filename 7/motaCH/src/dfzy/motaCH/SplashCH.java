package dfzy.motaCH;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class SplashCH extends ViewCH
{
	private int			tick		= 0;
	private Paint		paint		= null;
	private MainCH	mMainGame	= null;


	public SplashCH(Context context, MainCH mainGame)
	{
		super(context);
		paint = new Paint();
		mMainGame = mainGame;
		paint.setTextSize(yaCH.TextSize);
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
	}


	protected void onDraw(Canvas canvas)
	{
		tick++;
		paint.setColor(Color.BLACK);
		yaCH.fillRect(canvas, 0, 0, yaCH.SCREENW, yaCH.SCREENH, paint);

		paint.setColor(Color.WHITE);
		String string = "是否开启音效？";
		yaCH.drawString(canvas, string, (yaCH.SCREENW - paint.measureText(string)) / 2, (yaCH.SCREENH - paint.getTextSize()) / 2, paint);
		string = "是";
		yaCH.drawString(canvas, string, 5, yaCH.SCREENH - paint.getTextSize() - 5, paint);
		string = "否";
		yaCH.drawString(canvas, string, yaCH.SCREENW - paint.measureText(string) - 5, yaCH.SCREENH - paint.getTextSize() - 5, paint);
	}


	public boolean onKeyUp(int keyCode)
	{
		if (keyCode == yaCH.KEY_DPAD_OK)
		{
			mMainGame.mbMusic = 1;
		}
		mMainGame.controlView(yaCH.GAME_MENU);
		if (mMainGame.mbMusic == 1)
		{
			mMainGame.mCMIDIPlayer.PlayMusic(1);
		}
		return true;
	}


	public boolean onKeyDown(int keyCode)
	{
		return true;
	}


	public void refurbish()
	{
		// if (tick > 10)
		// {
		// mMainGame.controlView(yarin.GAME_MENU);
		// }
	}


	public void reCycle()
	{
		paint = null;
		System.gc();
	}
}
