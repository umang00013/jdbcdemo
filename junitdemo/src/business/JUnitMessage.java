package business;

public class JUnitMessage {
	String m;
    public JUnitMessage(String msg)
    {
        m=msg;
    }
public String printMessage()
{
    return m;
}

 

public String printHiMessage()
{
    return "Hi "+m;
}

}
