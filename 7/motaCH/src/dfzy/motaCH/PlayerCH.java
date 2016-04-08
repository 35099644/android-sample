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


	// 播放音乐
	public void PlayMusic(int ID)
	{
		FreeMusic();
		switch (ID)
		{
			case 1:
				//装载音乐
				playerMusic = MediaPlayer.create(magicTower, R.raw.menu);
				//设置循环
				playerMusic.setLooping(true);
				try
				{
					//准备
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
				//开始
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


	// 退出释放资源
	public void FreeMusic()
	{
		if (playerMusic != null)
		{
			playerMusic.stop();
			playerMusic.release();
		}
	}


	// 停止播放
	public void StopMusic()
	{
		if (playerMusic != null)
		{
			playerMusic.stop();
		}
	}
}
