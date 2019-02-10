package pokemon.view;

import java.util.Scanner;
import pokemon.service.HospitalRecordController;

public class RunningStartView {
	public static void main(String[] args) {
		HospitalRecordController controller = HospitalRecordController.getInstance();
		Scanner sc = new Scanner(System.in);
		int i = 0;
		// ȸ������
		System.out.println("******************************************************" + "\n");
		System.out.println("***-------------���������! ������� ġ���ϴ� ���ϸ󺴿��Դϴ� ��----------- ***" + "\n");
		System.out.println("******************************************************");

		while (true) {
			System.out.println("-------------(1)��ȣ�� (2)ȯ�� (3)����� (4)����--------------------");

			int a = sc.nextInt();

			switch (a) {
			case 1:
				i = 1;
				break;
			case 2:
				i = 2;
				break;
			case 3:
				i = 3;
				break;
			case 4:
				i = 4;
				break;
			default:
				System.out.println("-------------�߸��� ��ȣ�� �Է��߽��ϴ� �ٽ� �Է����ּ���--------------------");
				break;
			}
			while (true) {
				if (i == 1) {
					System.out.println("-------------(1)��ȣ�� ��� (2)��ȣ�� Ż�� (3)���� ȭ��---------------");
					int trainer = sc.nextInt();
					int i1 = 0;
					switch (trainer) {
					case 1:
						i1 = 1;
						break;
					case 2:
						i1 = 2;
						break;
					case 3:
						i1 = 3;
						break;
					default:
						System.out.println("-------------�߸��� ��ȣ�� �Է��߽��ϴ� �ٽ� �Է����ּ���--------------------");
						break;
					}
					if (i1 == 1) {
						System.out.println("-------------������ ������ �Է����ּ���-------------------------------");
						String name, gender, region, pokemon1, pokemon2, pokemon3, pokemon4, checkid;
						int id, age;
						System.out.println("[Ʈ���̳� ��ȣ �Է�]");
						id = sc.nextInt();
						System.out.println("[�̸� �Է�]");
						name = sc.next();
						System.out.println("[���� �Է�]");
						age = sc.nextInt();
						System.out.println("[���� �Է�]");
						gender = sc.next();
						System.out.println("[����� �Է�]");
						region = sc.next();
						System.out.println("[�����ϰ� ��� ���ϸ�(1)]");
						pokemon1 = sc.next();
						System.out.println("[�����ϰ� ��� ���ϸ�(2]");
						pokemon2 = sc.next();
						System.out.println("[�����ϰ� ��� ���ϸ�(3)]");
						pokemon3 = sc.next();
						System.out.println("[�����ϰ� ��� ���ϸ�(4)]");
						pokemon4 = sc.next();

						controller.addTrainerReqRes(id, name, age, gender, region, pokemon1, pokemon2, pokemon3, pokemon4);
						System.out.println("---------------������ ������ ����� �ԷµǾ����� Ȯ�����ּ���!----------------");
						System.out.println("[Ʈ������ ��ȣ �Է�]");
						checkid = sc.next();
						controller.getTrainer(checkid);
					} else if (i1 == 2) {
						System.out.println("-------------���� �������� ������ ������ �����մϴ�---------------------------");
						System.out.println("[Ʈ���̳� ��ȣ �Է�]");
						int trainerid;
						trainerid = sc.nextInt();
						controller.deleteTrainer(trainerid);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i1 == 3) {
						break;
					}
				} else if (i == 2) {
					System.out.println("-------------(1)���ϸ� �˻� (2)�Կ���� �˻� (3)���� ȭ��--------------");
					int pokemon = sc.nextInt();
					int i2 = 0;
					switch (pokemon) {
					case 1:
						i2 = 1;
						break;
					case 2:
						i2 = 2;
						break;
					case 3:
						i2 = 3;
						break;
					default:
						System.out.println("-------------�߸��� ��ȣ�� �Է��߽��ϴ� �ٽ� �Է����ּ���--------------------");
						break;
					}
					if (i2 == 1) {
						System.out.println("-------------ȯ���� ID�� �Է����ּ���-------------------------------");
						int no;
						System.out.println("[ȯ�� ID �Է�]");
						no = sc.nextInt();
						controller.getPokemon(no);
						System.out.println("-------------------------------------------------------------------");
					} else if (i2 == 2) {
						System.out.println("-------------ȯ���� ����� ��ȸ�մϴ�.---------------------------");
						System.out.println("[ȯ�� ID �Է�]");
						int id;
						id = sc.nextInt();
						controller.getHospital(id);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i2 == 3) {
						break;
					}
				} else if (i == 3) {
					System.out.println("---------------(1)�ǻ� �˻� (2) ���� ���� (3)���� ȭ��--------------------");
					int doctor = sc.nextInt();
					int i3 = 0;
					switch (doctor) {
					case 1:
						i3 = 1;
						break;
					case 2:
						i3 = 2;
						break;
					case 3:
						i3 = 3;
						break;
					default:
						System.out.println("-------------�߸��� ��ȣ�� �Է��߽��ϴ� �ٽ� �Է����ּ���--------------------");
						break;
					}
					if (i3 == 1) {
						System.out.println("-------------�ǻ� ID�� �Է����ּ���-------------------------------");
						int doctorid;
						System.out.println("[�ǻ� ID �Է�]");
						doctorid = sc.nextInt();
						controller.getDoctor(doctorid);
						System.out.println("-------------------------------------------------------------------");
					} else if (i3 == 2) {
						System.out.println("-------------�ǻ��� ������ �����մϴ�.---------------------------");
						int id;
						String major;
						System.out.println("[�ǻ� ID �Է�]");
						id = sc.nextInt();
						System.out.println("[������ ���� �Է�]");
						major = sc.next();
						controller.updateDoctor(id, major);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i3 == 3) {
						break;
					}
				} else if (i == 4) {
					System.out.println(
							"-------------(1) ��� �ǻ� �˻� (2) ��� ��ȣ�� �˻� (3) ��� �Կ���Ȳ �˻� (4) ��� �Է� (5)��� ���� (6) ���� ȭ��-----------------");
					int data = sc.nextInt();
					int i4 = 0;
					switch (data) {
					case 1:
						i4 = 1;
						break;
					case 2:
						i4 = 2;
						break;
					case 3:
						i4 = 3;
						break;
					case 4:
						i4 = 4;
						break;
					case 5:
						i4 = 5;
						break;
					case 6:
						i4 = 6;
						break;
					default:
						System.out.println("-------------�߸��� ��ȣ�� �Է��߽��ϴ� �ٽ� �Է����ּ���--------------------");
						break;
					}
					if (i4 == 1) {
						System.out.println("-------------���� ������ ��� �ǻ���� �Ұ��մϴ�~-------------------------------");
						controller.getAllDoctors();
						System.out.println(
								"-------------------------------------------------------------------------------");
					} else if (i4 == 2) {
						System.out.println("-------------���� ������ ����� �����ϴ� ��ȣ�ڵ��Դϴ�---------------------------");
						controller.getAllTrainers();
						System.out.println(
								"-------------------------------------------------------------------------------");
					} else if (i4 == 3) {
						System.out.println("-------------���� ������ �Կ� ��Ȳ�Դϴ�-------------------------------------");
						controller.getAllHospital();
						System.out
								.println("---------------------------------------------------------------------------");
					} else if (i4 == 4) {
						System.out.println("-----------------------��� �Է� â�Դϴ�-----------------------------------");
						int no, did, tid, pid;
						String indate, outdate;
						System.out.println("[��� ��ȣ �Է�]");
						no = sc.nextInt();
						System.out.println("[�ǻ� ID �Է�]");
						did = sc.nextInt();
						System.out.println("[��ȣ�� ID �Է�]");
						tid = sc.nextInt();
						System.out.println("[ȯ�� ID �Է�]");
						pid = sc.nextInt();
						System.out.println("[�Կ��� �Է�]");
						indate = sc.next();
						System.out.println("[��� ������ �Է�]");
						outdate = sc.next();

						controller.addHospitalReqRes(no, did, tid, pid, indate, outdate);
						System.out.println("-------------------------------------------------------------------------");
					} else if (i4 == 5) {
						System.out.println("-------------���� �������� ��� ���� ���� ���ŵ� �Կ� ��Ȳ�Դϴ�--------------");
						controller.refreshHospital();
						System.out.println("-------------------------------------------------------------------------");
					} else if (i4 == 6) {
						break;
					}
				}
			}
		}
	}
}
