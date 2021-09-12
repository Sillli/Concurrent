import TSim.*;

public class Train extends Thread{

private int trainId;
private int speed;

TSimInterface tsim = TSimInterface.getInstance();




    public Train(int trainId, int speed){
        this.trainId = trainId;
        this.speed = speed;
    }



    public void run() {

        try {
            tsim.setSpeed(trainId,25);
            while(true){
                toDo();

            }
        } catch (CommandException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void toDo() throws CommandException, InterruptedException {
        SensorEvent sensor = tsim.getSensor(trainId);
        if(sensor.getStatus()==SensorEvent.ACTIVE){
            tsim.setSpeed(trainId,0);

        }
    }

    public void changeSwitch(int xPos, int yPos, int dir) throws CommandException {
        tsim.setSwitch(xPos,yPos,dir);

    }




}