package hash;

import java.util.*;

public class 베스트앨범_programmers {

	public static void main(String[] args) {

		String[] a = {"classic", "pop", "classic", "classic", "pop"};
		int[] b = {500, 600, 150, 800, 2500};

		int[] result = solution(a, b);

		System.out.println(Arrays.toString(result));
		
	}


	public static int[] solution(String[] genres, int[] plays) {

		Music[] mlist = new Music[100];

		for (int i = 0; i < genres.length; i++) {

			for (int j = 0; j < mlist.length; j++) {
				if(mlist[j] == null) {
					Music m = new Music(genres[i], plays[i], i);
					mlist[j] = new Music(genres[i], plays[i], 0);
					mlist[j].next = m;
					break;
				}else if(mlist[j].genre.equals(genres[i])){
					sortMusic(mlist[j], new Music(genres[i], plays[i], i));
					break;
				}
			}
		}
		int cnt = 0;

		for (int i = 0; i < mlist.length; i++) {
			if(mlist[i] == null) break;
			cnt++;
		}


		Music[] resultMusic = new Music[cnt];
		for (int i = 0; i < cnt; i++) {
			resultMusic[i] = mlist[i];
		}

		Arrays.sort(resultMusic);

		List<Integer> tempList = new ArrayList<Integer>();

		for (Music m : resultMusic) {
			if(m.next != null)
				tempList.add(m.next.code);
			if(m.next.next != null)
				tempList.add(m.next.next.code);
		}

		int[] result = new int[tempList.size()];
		int idx = 0;
		for (int i : tempList) {
			result[idx++] = i;
		}


		return result;
	}

	public static void sortMusic(Music root, Music newMusic) {

		Music r = root;

		for (int i = 0; i < 2; i++) {
			if(r.next == null) break;

			if(r.next.play > newMusic.play) {
				r = r.next;
				continue;
			}else if(r.next.play == newMusic.play) {
				Music temp = r.next.next;
				r.next.next = newMusic;
				newMusic.next = temp;
				root.play += newMusic.play;
				return;
			}else if(r.next.play < newMusic.play) {
				Music temp = r.next;
				newMusic.next = temp;
				r.next = newMusic;
				root.play += newMusic.play;
				return;
			}
		}

		r.next = newMusic;
		root.play += newMusic.play;

	}
}

class Music implements Comparable<Music> {

	String genre;
	Music next;
	int play;
	int code;

	public Music(String genre, int play, int code) {
		super();
		this.genre = genre;
		this.play = play;
		this.code = code;
	}

	@Override
	public int compareTo(Music o) {
		if(this.play > o.play) return -1;
		else return 1;
	}
}