package AbstractFactoryPattern;

interface Button
{
	public void Click();
}
interface TextArea
{
	public String getText();
}

interface GuiFactory
{
	public Button createButton();
	public TextArea creatTextArea();
}
//==============================================
class WinButton implements Button
{
	@Override
	public void Click() {
		System.out.println("윈도우의 버튼이 클릭됨");
	}
}
class WinTextArea implements TextArea
{
	@Override
	public String getText() {
		return "윈도우의 텍스트에어리어";
	}
	
}

class WinFactory implements GuiFactory
{
	@Override
	public Button createButton() {
		return new WinButton();
	}
	@Override
	public TextArea creatTextArea() {
		return new WinTextArea();
	}
}
//==============================================
class MacButton implements Button
{
	@Override
	public void Click() {
		System.out.println("맥의 버튼이 클릭됨");
	}
}
class MacTextArea implements TextArea
{
	@Override
	public String getText() {
		return "맥의 텍스트에어리어";
	}
	
}

class MacFactory implements GuiFactory
{
	@Override
	public Button createButton() {
		return new MacButton();
	}
	@Override
	public TextArea creatTextArea() {
		return new MacTextArea();
	}
}
//==============================================
class LinButton implements Button
{
	@Override
	public void Click() {
		System.out.println("리눅스의 버튼이 클릭됨");
	}
}
class LinTextArea implements TextArea
{
	@Override
	public String getText() {
		return "리눅스의 텍스트에어리어";
	}
	
}

class LinFactory implements GuiFactory
{
	@Override
	public Button createButton() {
		return new LinButton();
	}
	@Override
	public TextArea creatTextArea() {
		return new LinTextArea();
	}
}
//==============================================
class GuiGetter
{
	public static GuiFactory getGuifac()
	{
		switch (System.getProperty("os.name")) {
		case "Windows 8.1":
			return new WinFactory();
		case "Mac OS X":
			return new MacFactory();
		default:
			break;
		}
		return null;
	}
}

public class main {

	public static void main(String[] args) {
		
		GuiFactory fac = GuiGetter.getGuifac();
		Button b = fac.createButton();
		TextArea t = fac.creatTextArea();
		b.Click();
		System.out.println(t.getText());
		
	}

}
