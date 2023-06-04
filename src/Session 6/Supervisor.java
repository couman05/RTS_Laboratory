import java.util.Scanner;

public class Supervisor extends Thread{

    boolean stop = false;
    PlaceHandler PH = new PlaceHandler();

    public Controller c;

    Supervisor_Transition_ts_1 ts_1;
    Supervisor_Transition_ts_2 ts_2;
    Supervisor_Transition_ts_3 ts_3;

    Scanner in = new Scanner(System.in);

    @Override
    public void run()
    {
        PH.AddPlace(new SupervisorPlace("ps_i1",null));
        PH.AddPlace(new SupervisorPlace("ps_1",0));
        PH.AddPlace(new SupervisorPlace("ps_o1",null));
        PH.AddPlace(new SupervisorPlace("ps_2",null));
        PH.AddPlace(new SupervisorPlace("ps_3",null));
        PH.AddPlace(new SupervisorPlace("ps_o2",null));
        PH.AddPlace(new SupervisorPlace("ps_i2",null));

        ts_1=new Supervisor_Transition_ts_1("ts_1",PH,0);
        ts_2=new Supervisor_Transition_ts_2("ts_2",PH,0);
        ts_3=new Supervisor_Transition_ts_3("ts_3",PH,0);
        ts_2.ControllerPH = c.PH;

        System.out.println("Controller: Input ps_i1 value");
		this.PH.GetPlaceByName("ps_i1").Set(Integer.parseInt(in.nextLine()));

        while (!stop) {

            ts_1.TransitionGuardsMappings();

            ts_2.TransitionGuardsMappings();

            ts_3.TransitionGuardsMappings();

            // For slower printing on the console
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
