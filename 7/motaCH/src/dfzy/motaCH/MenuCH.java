package dfzy.motaCH;

import dfzy.motaCH.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MenuCH extends ViewCH
{
	private String[]	menu		= { "新的游戏", "继续上次游戏", "帮助", "关于", "退出" };
	private int			itemNum		= menu.length;
	private int			curItem;
	private boolean		isFirstPlay	= false;
	public int			borderX, borderY;
	private Bitmap		mImgMenuBG	= null;

	private MainCH	mMainGame	= null;

	private int			split		= yaCH.TextSize + 5;

	private int			y;
	private Paint		paint		= null;


	public MenuCH(Context context, MainCH mainGame)
	{
		super(context);
		borderX = 0;
		borderY = 0;

		paint = new Paint();
		paint.setTextSize(yaCH.TextSize);
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		mMainGame = mainGame;

		mImgMenuBG = BitmapFactory.decodeResource(this.getResources(), R.drawable.menu);
	}


	private void next()
	{
		if ((curItem + 1) < itemNum)
			curItem++;
		else
			curItem = 0;
		if ((curItem == 1) && (isFirstPlay))
		{
			curItem++;
		}
	}


	private void pre()
	{
		if ((curItem - 1) >= 0)
			curItem--;
		else
			curItem = itemNum - 1;
		if ((curItem == 1) && (isFirstPlay))
		{
			curItem--;
		}
	}


	protected void onDraw(Canvas canvas)
	{
		paint.setColor(Color.BLACK);
		yaCH.fillRect(canvas, 0, 0, yaCH.SCREENW, yaCH.SCREENH, paint);

		yaCH.drawImage(canvas, mImgMenuBG, (yaCH.SCREENW - mImgMenuBG.getWidth()) / 2, 60);
		drawItem(canvas);
		y = (curItem + 1) * split + borderY + 200;

		paint.setARGB(255, 255, 0, 0);

		yaCH.drawString(canvas, menu[curItem], borderX + (yaCH.BORDERW - paint.measureText(menu[curItem])) / 2, y, paint);
	}


	public boolean onKeyUp(int keyCode)
	{
		switch (keyCode)
		{
			case yaCH.KEY_DPAD_UP:
				pre();
				break;
			case yaCH.KEY_DPAD_DOWN:
				next();
				break;
			case yaCH.KEY_DPAD_OK:
				dealItem();
				break;
			case yaCH.KEY_SOFT_RIGHT:
				mMainGame.getMagicTower().finish();
				break;
		}
		return true;
	}


	public boolean onKeyDown(int keyCode)
	{
		return true;
	}


	private void drawItem(Canvas canvas)
	{
		paint.setColor(Color.WHITE);
		for (int i = 0; i < itemNum; i++)
		{
			y = (i + 1) * split + borderY + 200;

			yaCH.drawString(canvas, menu[i], borderX + (yaCH.BORDERW - paint.measureText(menu[i])) / 2, y, paint);
		}
	}


	private void dealItem()
	{
		switch (curItem)
		{
			case 0:
				mMainGame.controlView(yaCH.GAME_RUN);
				if (mMainGame.mbMusic == 1)
				{
					mMainGame.mCMIDIPlayer.PlayMusic(2);
				}
				break;
			case 1:
				mMainGame.controlView(yaCH.GAME_CONTINUE);
				if (mMainGame.mbMusic == 1)
				{
					mMainGame.mCMIDIPlayer.PlayMusic(2);
				}
				break;
			case 2:
				mMainGame.controlView(yaCH.GAME_HELP);
				break;
			case 3:
				mMainGame.controlView(yaCH.GAME_ABOUT);
				break;
			case 4:
				if (mMainGame.mCMIDIPlayer != null)
				{
					mMainGame.mCMIDIPlayer.FreeMusic();
					mMainGame.mCMIDIPlayer = null;
				}
				System.gc();
				mMainGame.getMagicTower().finish();
				break;
		}
	}


	public void refurbish()
	{

	}


	public void reCycle()
	{
		mImgMenuBG = null;
		paint = null;
		System.gc();
	}
}
