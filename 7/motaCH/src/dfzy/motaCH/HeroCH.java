package dfzy.motaCH;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import javax.game.SpriteCH;

import android.graphics.Bitmap;

public class HeroCH extends SpriteCH
{
	private int		hp			= 1000;
	private int		attack		= 100;
	private int		defend		= 100;
	private int		experience	= 0;
	private int		money		= 0;

	private int		level		= 1;
	private int		yellowKey	= 100;
	private int		blueKey		= 100;
	private int		redKey		= 100;

	public boolean	canLookup	= false;
	public boolean	canJump		= false;

	private TaskCH	task;


	public HeroCH(Bitmap image, int frameWidth, int frameHeight)
	{
		super(image, frameWidth, frameHeight);

	}


	public void setTask(TaskCH task)
	{
		this.task = task;
	}


	public boolean useKey(int key)
	{
		boolean result = false;
		switch (key)
		{
			case MapCH.MAP_YELLOW_DOOR:
				if (yellowKey > 0)
				{
					yellowKey--;
					result = true;
				}
				break;
			case MapCH.MAP_BLUE_DOOR:
				if (blueKey > 0)
				{
					blueKey--;
					result = true;
				}
				break;
			case MapCH.MAP_RED_DOOR:
				if (redKey > 0)
				{
					redKey--;
					result = true;
				}
				break;
		}
		return result;
	}


	// take gem
	public String takeGem(int type)
	{
		String result = "";
		switch (type)
		{
			case MapCH.MAP_YELLOW_KEY:
				yellowKey++;
				result = "���һ�ѻ�Կ�ף�";
				break;
			case MapCH.MAP_BLUE_KEY:
				blueKey++;
				result = "���һ����Կ�ף�";
				break;
			case MapCH.MAP_RED_KEY:
				redKey++;
				result = "���һ�Ѻ�Կ�ף�";
				break;
			case MapCH.MAP_KEY_RING:
				yellowKey++;
				blueKey++;
				redKey++;
				result = "�õ�Կ�׺У�����Կ������1��";
				break;
			case MapCH.MAP_SMALL_BLOOD:
				hp += 200;
				result = "�õ�һ��СѪƿ������ֵ��200��";
				break;
			case MapCH.MAP_BIG_BLOOD:
				hp += 500;
				result = "�õ�һ����Ѫƿ������ֵ��500��";
				break;
			case MapCH.MAP_RED_GEM:
				attack += 3;
				result = "�õ�һ���챦ʯ����������3��";
				break;
			case MapCH.MAP_BLUE_GEM:
				defend += 3;
				result = "�õ�һ������ʯ����������3��";
				break;
			case MapCH.MAP_SWORD1:
				attack += 10;
				result = "�õ�������������10��";
				break;
			case MapCH.MAP_SWORD2:
				attack += 40;
				result = "�õ��ֽ���������40��";
				break;
			case MapCH.MAP_SWORD3:
				attack += 70;
				result = "�õ���潣��������70 ��";
				break;
			case MapCH.MAP_SWORD4:
				attack += 110;
				result = "�õ�ʥ�⽣��������110 ��";
				break;
			case MapCH.MAP_SWORD5:
				attack += 150;
				result = "�õ��ǹ��񽣣�������150 ��";
				break;
			case MapCH.MAP_SHIELD1:
				defend += 10;
				result = "�õ����ܣ���������10 ��";
				break;
			case MapCH.MAP_SHIELD2:
				defend += 30;
				result = "�õ��ֶܣ�������30 ��";
				break;
			case MapCH.MAP_SHIELD3:
				defend += 85;
				result = "�õ��ƽ�ܣ�������85 ��";
				break;
			case MapCH.MAP_SHIELD4:
				defend += 120;
				result = "�õ��ǹ�ܣ������� 120 ��";
				break;
			case MapCH.MAP_SHIELD5:
				defend += 190;
				result = "�õ���â��ܣ�������190 ��";
				break;
			case MapCH.MAP_LOOKUP:
				canLookup = true;
				result = "�õ�ʥ��գ�������3�����ɲ鿴���й��������ֵ��";
				break;
			case MapCH.MAP_JUMP:
				canJump = true;
				result = "�õ���֮���̣�������1��������ȥ����¥����������£�";
				break;
			case MapCH.MAP_LEVEL_UP1:
				levelUp(1);
				result = "�õ�С���𣬵ȼ�����һ�� ��";
				break;
			case MapCH.MAP_LEVEL_UP3:
				levelUp(3);
				result = "�õ�����𣬵ȼ��������� ��";
				break;
			case MapCH.MAP_COIN:
				money += 300;
				result = "�õ���飬�������300 ��";
				break;
			case MapCH.MAP_DOUBLE_BLOOD:
				hp = hp * 2;
				result = "�õ�ʥˮƿ��������ֵ�ӱ���";
				break;
			case MapCH.MAP_CROSS:
				task.updateTaskState(TaskCH.FIND_CROSS);
				result = "�õ� ����ʮ�ּ� ������������ ����������������ֵ";
				break;
			case MapCH.MAP_AX:
				task.updateTaskState(TaskCH.FIND_AX);
				result = "�õ� �ǹ���� ��������С͵ ���Դ�ͨʮ�˲�����ص���";
				break;
		}
		return result;
	}


	public void levelUp(int value)
	{
		level += value;
		hp += 1000 * value;
		attack += 7 * value;
		defend += 7 * value;
	}


	public int getAttack()
	{
		return attack;
	}


	public int getHp()
	{
		return hp;
	}


	public int getDefend()
	{
		return defend;
	}


	public int getMoney()
	{
		return money;
	}


	public int getExperience()
	{
		return experience;
	}


	public void cutHp(int value)
	{
		hp -= value;
	}


	public void addHp(int value)
	{
		hp += value;
	}


	public void setHp(int value)
	{
		hp = value;
	}


	public void addMoney(int value)
	{
		money += value;
	}


	public void cutMoney(int value)
	{
		money -= value;
	}


	public void addExperience(int value)
	{
		experience += value;
	}


	public void cutExperience(int value)
	{
		experience -= value;
	}


	public void addAttack(int value)
	{
		attack += value;
	}


	public void addDefend(int value)
	{
		defend += value;
	}


	public void addYellowKey()
	{
		yellowKey++;
	}


	public void cutYellowKey()
	{
		yellowKey--;
	}


	public void addBlueKey()
	{
		blueKey++;
	}


	public void cutBlueKey()
	{
		blueKey--;
	}


	public void addRedKey()
	{
		redKey++;
	}


	public void cutRedKey()
	{
		redKey--;
	}


	public int getYellowKey()
	{
		return yellowKey;
	}


	public int getBlueKey()
	{
		return blueKey;
	}


	public int getRedKey()
	{
		return redKey;
	}


	public int getLevel()
	{
		return level;
	}


	public byte[] encode()
	{
		byte[] result = null;
		try
		{

			ByteArrayOutputStream bstream = new ByteArrayOutputStream();
			DataOutputStream ostream = new DataOutputStream(bstream);
			ostream.writeInt(level);
			ostream.writeInt(hp);
			ostream.writeInt(attack);
			ostream.writeInt(defend);
			ostream.writeInt(money);
			ostream.writeInt(experience);
			ostream.writeInt(yellowKey);
			ostream.writeInt(blueKey);
			ostream.writeInt(redKey);
			// canlookup
			if (canLookup == true)
			{
				ostream.writeInt(1);
			}
			else
			{
				ostream.writeInt(0);
			}
			// canjump
			if (canJump == true)
			{
				ostream.writeInt(1);
			}
			else
			{
				ostream.writeInt(0);
			}
			result = bstream.toByteArray();
		}
		catch (Exception e)
		{
			System.out.println("encode error::" + e);
		}
		return result;

	}


	// decode the byte[] from RMS
	public void decode(byte[] data)
	{
		try
		{

			ByteArrayInputStream bstream = new ByteArrayInputStream(data);
			DataInputStream istream = new DataInputStream(bstream);
			level = istream.readInt();
			hp = istream.readInt();
			attack = istream.readInt();
			defend = istream.readInt();
			money = istream.readInt();
			experience = istream.readInt();
			yellowKey = istream.readInt();
			blueKey = istream.readInt();
			redKey = istream.readInt();
			int can = istream.readInt();
			// canlookup
			if (can == 0)
			{
				canLookup = false;
			}
			else
			{
				canLookup = true;
			}
			can = istream.readInt();
			// canjump
			if (can == 0)
			{
				canJump = false;
			}
			else
			{
				canJump = true;
			}
		}
		catch (Exception e)
		{
			System.out.println("decode error::" + e);
		}
	}
}
