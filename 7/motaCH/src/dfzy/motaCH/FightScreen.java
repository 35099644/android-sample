package dfzy.motaCH;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class FightScreen
{
	private Paint			paint		= null;
	
	private boolean isFighting = true;
	private ScreenCH gameScreen;
	private boolean heroFirst;
	private Canvas mcanvas;
	private HeroCH hero;
	
	//private int boutNum;
	private int orgeHp;
	private int orgeAttack;
	private int orgeDefend;
	private int orgeMoney;
	private int orgeExperience;
	private int heroDamagePerBout;
	private int orgeDamagePerBout; 
	
	private int orgeSrcX,orgeSrcY,
				 w = MapCH.TILE_WIDTH;
	
	private int orgeType;
	private Bitmap orgeImage = null;
	private Bitmap heroImage = null;
	
	public TextCH			tu=null;
	
	public FightScreen(ScreenCH gameScreen, FightCH fightCalc, HeroCH hero, int type)
	{
		this.gameScreen = gameScreen;
		paint = new Paint();
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		tu = new TextCH();

		orgeImage = gameScreen.getImage(ScreenCH.IMAGE_MAP);
		heroImage = gameScreen.getImage(ScreenCH.IMAGE_HERO);

		this.hero = hero;
		this.orgeType = type;

		int[] orgeAttr = fightCalc.getOrgeAttr(orgeType);
		orgeHp = orgeAttr[FightCH.HP];
		orgeAttack = orgeAttr[FightCH.ATTACK];
		orgeDefend = orgeAttr[FightCH.DEFEND];
		orgeMoney = orgeAttr[FightCH.MONEY];
		orgeExperience = orgeAttr[FightCH.EXPERIENCE];

		int[] fightParam = fightCalc.getFightParam();
		heroDamagePerBout = fightParam[FightCH.HERO_DAMAGE_PER_BOUT];
		orgeDamagePerBout = fightParam[FightCH.ORGE_DAMAGE_PER_BOUT];

		int[] srcXY = calcXY(orgeType - 1);
		orgeSrcX = srcXY[0];
		orgeSrcY = srcXY[1];

	}


	private int[] calcXY(int index)
	{
		int[] result = { 0, 0 };
		int row = index / 11;
		int col = index - row * 11;
		result[0] = col * w;
		result[1] = row * w;
		return result;
	}


	protected void onDraw(Canvas canvas)
	{
		mcanvas = canvas;

		int tx, ty, tw, th;
		tw = yaCH.SCREENW;
		th = yaCH.MessageBoxH;
		tx = 0;
		ty = (yaCH.SCREENH - yaCH.MessageBoxH) / 2;

		showMessage();

		if (!isFighting)
		{
			tu.DrawText(mcanvas);
		}
		else
		{
			yaCH.drawImage(canvas, orgeImage, 0, ty + (th - MapCH.TILE_WIDTH) / 2, MapCH.TILE_WIDTH, MapCH.TILE_WIDTH, orgeSrcX, orgeSrcY);
			yaCH.drawImage(canvas, heroImage, (tw - MapCH.TILE_WIDTH), ty + (th - MapCH.TILE_WIDTH) / 2, MapCH.TILE_WIDTH, MapCH.TILE_WIDTH, 0, 0);
			paint.setColor(Color.WHITE);
			// 怪物
			{
				tx = 40;
				ty = (yaCH.SCREENH - yaCH.MessageBoxH) / 2 + 5;
				yaCH.drawString(canvas, "生命:" + orgeHp, tx, ty, paint);
				yaCH.drawString(canvas, "攻击:" + orgeAttack, tx, ty + yaCH.TextSize, paint);
				yaCH.drawString(canvas, "防御:" + orgeDefend, tx, ty + 2 * yaCH.TextSize, paint);
			}
			// 英雄
			{
				String string = "";
				ty = (yaCH.SCREENH - yaCH.MessageBoxH) / 2 + 5;
				string = hero.getHp() + ":生命";
				yaCH.drawString(canvas, string, (tw - 40 - paint.measureText(string)), ty, paint);
				string = hero.getAttack() + ":攻击";
				yaCH.drawString(canvas, string, (tw - 40 - paint.measureText(string)), ty + yaCH.TextSize, paint);
				string = hero.getDefend() + ":防御";
				yaCH.drawString(canvas, string, (tw - 40 - paint.measureText(string)), ty + 2 * yaCH.TextSize, paint);
			}
		}

		tick();
	}


	public void showMessage()
	{
		int x = 0;
		int y = (yaCH.SCREENH - yaCH.MessageBoxH) / 2;
		int w = yaCH.SCREENW;
		int h = yaCH.MessageBoxH;
		Paint ptmPaint = new Paint();
		ptmPaint.setARGB(255, 0, 0, 0);

		yaCH.fillRect(mcanvas, x, y, w, h, ptmPaint);

		ptmPaint = null;
	}


	private void tick()
	{
		if (orgeHp <= 0)
		{
			isFighting = false;
			tu.InitText("得到" + orgeMoney + "个金币  " + "经验值增加" + orgeExperience, 0, (yaCH.SCREENH - yaCH.MessageBoxH) / 2, yaCH.SCREENW, yaCH.MessageBoxH,
				0x0, 0xff0000, 255, yaCH.TextSize);
		}
		else if (heroFirst == true)
		{
			orgeHp -= orgeDamagePerBout;
			if (orgeHp <= 0)
			{
				orgeHp = 0;
			}
		}
		else
		{
			hero.cutHp(heroDamagePerBout);
		}
		heroFirst = !heroFirst;
	}


	public boolean onKeyUp(int keyCode)
	{
		switch (keyCode)
		{
			case yaCH.KEY_DPAD_UP:
				break;
			case yaCH.KEY_DPAD_DOWN:
				break;
			case yaCH.KEY_DPAD_OK:
				if (!isFighting)
				{
					hero.addMoney(orgeMoney);
					hero.addExperience(orgeExperience);
					gameScreen.mshowFight = false;
					gameScreen.mFightScreen = null;
					System.gc();
				}
				break;
			case yaCH.KEY_SOFT_RIGHT:
				break;
		}
		return true;
	}
}

