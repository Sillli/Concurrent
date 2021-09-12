import TSim.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Lab1 {

  public Lab1(int speed1, int speed2) {
    TSimInterface tsi = TSimInterface.getInstance();
    List<Semaphore> phores = new ArrayList<>();

    for(int i = 0; i... ; i++){
      phores.add(new Semaphore(1));
    }

    Train train1 = new Train(1,speed1);
    Train train2 = new Train(2,speed2);

    List<CritArea> CritAreas = new ArrayList<>();
    CritAreas.add(new CritArea(Arrays.asList(7,8,9,8), Arrays.asList(7,6,7,8),0, 0,null));
    CritAreas.add(new CritArea(Arrays.asList(16,17,18), Arrays.asList(7,7,8),1, 1, new Switch(17,7)));
    CritAreas.add(new CritArea(Arrays.asList(14,16,15), Arrays.asList(9,9,10),2, 2, new Switch(15,9)));
    CritAreas.add(new CritArea(Arrays.asList(3,5,4), Arrays.asList(9,9,10),3, 3, new Switch(4,9)));
    CritAreas.add(new CritArea(Arrays.asList(2,4,3), Arrays.asList(11,11,12),4, 4, new Switch(3,11)));
    train1.start();
    train2.start();


  }

}

class CritArea{

  private final List<Integer> xPos;
  private final List<Integer> yPos;
  private final Switch sch;
  private int area;
  private int sema;


  public CritArea(List<Integer> xPos, List<Integer> yPos, int area, int sema, Switch sch){
    this.xPos = xPos;
    this.yPos = yPos;
    this.sema = sema;
    this.area = area;
    this.sch = sch;
  }


  
}

class Switch{
  TSimInterface tsim = TSimInterface.getInstance();
  private int XPOS ;
  private int YPOS ;

  public Switch(int XPOS, int YPOS){
    this.XPOS = XPOS;
    this.YPOS = YPOS;

  }

  public void changeSwitch(int dir) throws CommandException {
    tsim.setSwitch(XPOS, XPOS, dir);

  }
}






