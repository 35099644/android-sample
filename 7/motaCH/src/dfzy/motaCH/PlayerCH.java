package dfzy.motaCH;

import java.io.IOException;

import dfzy.motaCH.R;

import android.media.MediaPlayer;

public class PlayerCH
{
	public MediaPlayer	playerMusic;

	public MagicCH	magicTower	= null;


	public PlayerCH(MagicCH magicTower)
	{
		this.magicTower = magicTower;

	}


	// ��������
	public void PlayMusic(int ID)
	{
		FreeMusic();
		switch (ID)
		{
			case 1:
				//װ������
				playerMusic = MediaPlayer.create(magicTower, R.raw.menu);
				//����ѭ��
				playerMusic.setLooping(true);
				try
				{
					//׼��
					playerMusic.prepare();
				}
				catch (IllegalStateException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				//��ʼ
				playerMusic.start();
				break;
			case 2:
				playerMusic = MediaPlayer.create(magicTower, R.raw.run);
				playerMusic.setLooping(true);
				try
				{
					playerMusic.prepare();
				}
				catch (IllegalStateException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				playerMusic.start();
				break;
		}
	}


	// �˳��ͷ���Դ
	public void FreeMusic()
	{
		if (playerMusic != null)
		{
			playerMusic.stop();
			playerMusic.release();
		}
	}


	// ֹͣ����
	public void StopMusic()
	{
		if (playerMusic != null)
		{
			playerMusic.stop();
		}
	}
}
