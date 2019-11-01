package com.la.night_owl.character;

import com.la.night_owl.avoiding_rain.Avoiding_Rain;

public class CollisionManager {
	DdongManager ddongManager;
	Avoiding_Rain avoiding_Rain;
	public int key_Count = 1;

	public CollisionManager() {
	}

	public CollisionManager(DdongManager ddongManager, Avoiding_Rain avoiding_Rain) {
		super();
		this.ddongManager = ddongManager;
		this.avoiding_Rain = avoiding_Rain;
	}

	public void collision_User_Ddong() {
		for (Ddong ddong : ddongManager.ddongList) {
			if (avoiding_Rain.user.position.intersects(ddong.position)) {
				ddongManager.ddongList.remove(ddong);
				System.out.println(key_Count++);
				return;
			}

		}
	}

}
