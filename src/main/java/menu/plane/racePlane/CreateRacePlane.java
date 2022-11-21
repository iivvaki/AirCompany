package menu.plane.racePlane;

import java.util.Scanner;

import static java.lang.System.out;

public class CreateRacePlane {
    public RacePlane createRacePlane(){
        Scanner in = new Scanner(System.in);
        out.println("��� �������� ����� ������������ ������� ��� �������!");

        out.print("����� --> "); String name = in.nextLine();
        out.print("�-�� ������(�� ����� 2) --> "); int countOfCrew = in.nextInt();
        while (true){
            if(countOfCrew > 2 || countOfCrew < 1){
                out.print("�� ����� ������ ������� ����� ������...\n�������� ������ --> ");
                countOfCrew = in.nextInt();
            }else {
                break;
            }
        }

        System.out.print("������� --> "); double length = in.nextDouble();
        out.print("������ --> "); double height = in.nextDouble();
        out.print("������ ���� --> "); double wingspan = in.nextDouble();
        out.print("����� ���� --> "); double wingArea = in.nextDouble();
        out.print("���� ����������(��� ������ ����, ��� ����� �� ���) --> "); int emptyMass = in.nextInt();
        out.print("����� ������� --> "); String nameEngine = in.nextLine();
        out.print("��������� �������(�.�.) --> "); int enginePower = in.nextInt();
        out.print("����������� �������� --> "); double speed = in.nextInt();
        out.print("�������� ������� --> "); int range = in.nextInt();
        out.print("��������������� --> "); int highSpeed = in.nextInt();

        return new RacePlane("��������", name, 0, length, 0, height, wingspan,
                0, 0,0,0,range, 0,nameEngine,
                1, wingArea, 0,0,0,0,0,speed,
                countOfCrew, emptyMass, highSpeed, enginePower, 0, 0);
    }
}
