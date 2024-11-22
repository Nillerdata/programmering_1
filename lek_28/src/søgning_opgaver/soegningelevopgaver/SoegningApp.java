package søgning_opgaver.soegningelevopgaver;

public class SoegningApp {

	public static boolean findUlige(int[] tabel) {
		boolean fundetUlige = false;
		int i = 0;

		while(!fundetUlige &&  i <tabel.length ){
			int k = tabel[i];
			if(k % 2  == 1){
				fundetUlige = true;
			}else i++;
		}
		return fundetUlige;
	}

	// her skriver du metoder til opgaverne 2,3,5,6 og 7
	//TODO opgave 2
	public static int interval1015(int[]tabel){
		int i = 0;
		int indeks = -1;
		boolean isFound = false;
		while (!isFound && i<tabel.length){
			if(tabel[i] >=10 && tabel[i] <=15){
				indeks = tabel[i];
				isFound = true;
			}else  i++;
		}return indeks;
	}
	//___________________________________________-
	//TODO opgave 3
	public static boolean equalNext(int[]tabel){
		boolean isFound = false;
		int i = 0;

		while(!isFound && i < tabel.length-1){
			if(tabel[i] == tabel[i +1]){
				isFound = true;
			}else i++;
		}return isFound;
	}
	//__________________________
	//TODO opgave 4

	public static void main(String[] args) {
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));
		int[] opgave2Array = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println("find første tal mellem 10 og 15" + interval1015(opgave2Array));

		int[] opgave3Array  ={7,9,13,7,9,13};
		int[] opgave3Array1 = {7,9,13,9,9,8};
		System.out.println("står ens tal ved siden af? " + equalNext(opgave3Array));
		System.out.println("står ens tal ved siden af? " + equalNext(opgave3Array1));
		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
	}

}
