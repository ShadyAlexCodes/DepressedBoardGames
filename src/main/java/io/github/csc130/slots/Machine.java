package io.github.csc130.slots;

import io.github.csc130.utils.Utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Machine {
    private int slotAmount = 3;
    private  String[] strEmojis = new String[slotAmount];
    private  int[] intValues = new int[slotAmount];
    public String[] getStrEmojis() {
        return strEmojis;
    }
    private double totalPayOut;
    private double putIn;

    public double getPutIn() {
        return putIn;
    }

    public void setPutIn(double putIn) {

        this.putIn = putIn;
    }

    public void setStrEmojis() {
        this.strEmojis = generateResults();
    }

    private String[] generateResults(){
        for (int index = 0; index < slotAmount; index++) {
            Random random = new Random();
            int num =random.nextInt(9);
            intValues[index] = num;
            switch (num){
                case 0:
                    //☠
                    strEmojis[index] = "\u2620";
                    break;
                case 1:
                    //🤡
                    strEmojis[index] = "\uD83E\uDD21";
                    break;
                case 2:
                    //👻
                    strEmojis[index] = "\uD83D\uDC7B";
                    break;
                case 3:
                    //👾
                    strEmojis[index] = "\uD83D\uDC7E";
                    break;
                case 4:
                    //💖
                    strEmojis[index] = "\uD83D\uDC96";
                    break;
                case 5:
                    //🦋
                    strEmojis[index] = "\uD83E\uDD8B";
                    break;
                case 6:
                    //🏵
                    strEmojis[index] = "\uD83C\uDFF5";
                    break;
                case 7:
                    //👽
                    strEmojis[index] = "\uD83D\uDC7D";
                    break;
                case 8:
                    //🌈
                    strEmojis[index] = "\uD83C\uDF08";
                    break;
            }

        }
        return strEmojis;
    }
    public double calculatePayout(){
        if(intValues[0]==intValues[1]&&intValues[0]==intValues[2]){
            totalPayOut = (intValues[0]+1)*10;
        } else if (intValues[0]==intValues[1]||intValues[1]==intValues[2]) {
            totalPayOut = (intValues[0]+1)*8;
        } else if (intValues[0]==intValues[2]) {
            totalPayOut = (intValues[0]+1)*5;
        }
        return totalPayOut;
    }
    public void printConsoleResults(){
        Utils.writeLn("-----------");
        Utils.write("|");
        for (String emoji: strEmojis) {
            Utils.write(emoji);
            Utils.write("|");
        }
        Utils.writeLn("");
        Utils.writeLn("-----------");
    }

    public void pull(){
        setPutIn(Utils.getDoubleInput("Place the amount you are betting: ", Utils.TextColor.GREEN));
        setStrEmojis();
        printConsoleResults();
        calculatePayout();
        Utils.writeLn("You made $"+totalPayOut+".", Utils.TextColor.GREEN);
    }
}
