package OnlineBankSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CustomerManager customerManager = new CustomerManager();
		
		// Default System Users
		customerManager.register("1234214213124", "password", 1500.232);
		customerManager.register("523523523", "123", 2200.652);
		customerManager.register("652465896", "sifresifre", 500.0);
		
		Scanner sc = new Scanner(System.in);
				
		while (true) {
			
			System.out.println("--------------Online Bank------------------");
			System.out.println("--------------Hoşgeldiniz------------------");
			System.out.println("1 - Giriş Yap");
			System.out.println("2 - Hesap Oluştur");
			System.out.println("3 - Çıkış Yap");
			int choice = sc.nextInt();
			
			if (choice == 3) {
				System.out.println("Çıkış yapıldı! İyi günler!");
				break;
			} else if (choice == 2) {
				System.out.println("--------------Hesap Oluştur------------------");
				System.out.print("Kimlik Numarası: ");
				String identityNumber = sc.next();
				System.out.print("Şifre: ");
				String password = sc.next();
				System.out.print("Para: ");
				double money = sc.nextDouble();				
				
				customerManager.register(identityNumber, password, money);
				
				System.out.println("               Hesap Oluşturuldu!                ");
			} else if (choice == 1) {
				
				System.out.println("--------------Giriş Yap------------------");
				System.out.print("Kimlik Numarası: ");
				String identityNumber = sc.next();
				System.out.print("Þifre: ");
				String password = sc.next();
				
				customerManager.login(identityNumber, password);
				System.out.println("               Giriş İþlemi Başarılı                ");
				System.out.println("--------------İşlemler------------------");
				System.out.println("1 - Para Transferi");
				System.out.println("2 - Kart Borcu Öde");
				System.out.println("3 - Kredi Borcu Öde");
				System.out.println("4 - Çıkış Yap");
				
				int selected = sc.nextInt();
				
				switch (selected) {
				case 1:
					System.out.println("--------------Para Transferi------------------");
					System.out.print("Hesap Numarası: ");
					String fromAccount = sc.next();
					System.out.print("Hangi Hesaba: ");
					String toAccount = sc.next();
					System.out.print("Gönderilecek Tutar: ");
					double money = sc.nextDouble();
					
					customerManager.moneyTransfer(fromAccount, toAccount, money);
					break;
					
				case 2:
					System.out.println("--------------Kart Borcu Öde------------------");
					System.out.print("Hesap Numarası: ");
					String account = sc.next();
					
					customerManager.payCardDebt(account);
					break;
				case 3:
					System.out.println("--------------Kredi Borcu Öde------------------");
					System.out.print("Hesap Numarası: ");
					String accountNum = sc.next();
					
					customerManager.payDebt(accountNum);
					break;
				case 4:
					break;
					
				default:
					System.out.println("Geçersiz İşlem");
					break;
				}

			} else {
				System.out.println("Lütfen Geçerli bir işlem seçiniz!");
			}
			
		}
		
	}

}
