package dfzy.motaCH;

import dfzy.motaCH.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class AboutCH extends ViewCH
{
	private MainCH	mMainGame	= null;
	private Paint		paint		= null;
	private TextCH	tu			= null;


	public AboutCH(Context context, MainCH mainGame)
	{
		super(context);
		mMainGame = mainGame;
		paint = new Paint();
		tu = new TextCH();
		Resources r = this.getContext().getResources();
		tu.InitText(((String) r.getString(R.string.about)), 0, 0, yaCH.SCREENW, yaCH.SCREENH, 0x0, 0xff0000, 255, yaCH.TextSize);
	}


	protected void onDraw(Canvas canvas)
	{
		paint.setColor(Color.BLACK);
		yaCH.fillRect(canvas, 0, 0, yaCH.SCREENW, yaCH.SCREENH, paint);
		tu.SetTextColor(0xffff00);
		tu.DrawText(canvas);
	}


	public boolean onKeyUp(int keyCode)
	{
		if (keyCode == yaCH.KEY_DPAD_UP || keyCode == yaCH.KEY_DPAD_DOWN)
		{
			tu.Key(keyCode);
		}
		else
		{
			mMainGame.controlView(yaCH.GAME_MENU);
		}
		return true;
	}


	public boolean onKeyDown(int keyCode)
	{
		return true;
	}


	public void refurbish()
	{

	}


	public void reCycle()
	{
		paint = null;
		tu = null;
		System.gc();
	}
}
