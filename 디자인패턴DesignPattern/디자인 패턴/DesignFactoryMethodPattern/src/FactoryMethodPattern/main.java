package FactoryMethodPattern;

import java.util.Date;

interface item {
	public void use();
}

class MpPotion implements item {
	@Override
	public void use() {
		System.out.println("Mp를 회복한다.");
	}
}

class HpPotion implements item {
	@Override
	public void use() {
		System.out.println("Hp를 회복한다.");
	}
}

class BFsword implements item {
	@Override
	public void use() {
		System.out.println("공격력이 45오른다 ");
	}
}

abstract class ItemCreator {
	
	public item createItem() {
		item i;
		searchDB();
		i = create();
		printLog();
		return i;
	}

	protected abstract void printLog();

	protected abstract item create();

	protected abstract void searchDB();
}

class Mpcreator extends ItemCreator {

	@Override
	protected void printLog() {

		System.out.println("Log::Mp_potion Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new MpPotion();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub
		System.out.println("데이터베이스에서 Mp포션에 대한 정보를 받아온다.");
	}

}

class Hpcreator extends ItemCreator {

	@Override
	protected void printLog() {
		System.out.println("Log::Hp_potion Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new HpPotion();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub

		System.out.println("데이터베이스에서 Hp포션에 대한 정보를 받아온다.");
	}

}

class BFcreator extends ItemCreator {
	@Override
	protected void printLog() {
		System.out.println("Log::BF_sword Create" + new Date().getTime());
	}

	@Override
	protected item create() {
		return new BFsword();
	}

	@Override
	protected void searchDB() {
		// TODO Auto-generated method stub

		System.out.println("데이터베이스에서 BF대검에 대한 정보를 받아온다.");
	}
}

public class main {

	public static void main(String[] args) {

		ItemCreator creator = new Mpcreator();
		item i = creator.createItem();
		i.use();

		creator = new Hpcreator();
		i = creator.createItem();
		i.use();
		
		creator = new BFcreator();
		i = creator.createItem();
		i.use();

	}

}