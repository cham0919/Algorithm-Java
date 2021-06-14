package 프로그래머스.해시;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42579?language=python3
 */
public class 베스트앨범 {

    public static void main(String[] args) {

        베스트앨범 test = new 베스트앨범();
        List<String[]> genres = getGenresTestCases();
        List<int[]> plays = getPlaysTestCases();
        List<int[]> results = getResultTestCases();

        for (int i = 0; i < genres.size(); i++) {
            int[] result = test.solution1(genres.get(i), plays.get(i));

            if (Arrays.equals(result, results.get(0))) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        }
    }


    public static int[] solution1(String[] genres, int[] plays) {
        List<Integer> resultList = new ArrayList<>();
        Map<String, List<Music>> playListMap = new HashMap<>();
        Map<String, Integer> playCountMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Music music = new Music().setIdx(i)
                    .setPlay(plays[i]);

            if (playListMap.containsKey(genres[i])){
                playListMap.get(genres[i])
                        .add(music);
                playCountMap.put(genres[i], playCountMap.get(genres[i]) + plays[i]);
            } else {
                playListMap.put(genres[i], new ArrayList<Music>(){{
                    add(music);
                }});
                playCountMap.put(genres[i], plays[i]);
            }
        }

        List<String> keySetList = new ArrayList(playCountMap.keySet());

        // 오름차순
        keySetList.sort((o1, o2) -> playCountMap.get(o2) - playCountMap.get(o1));



        for ( String key : keySetList){
            List<Music> musics = playListMap.get(key);
            Collections.sort(musics);
            int i = 0;
            for( Music music : musics){
                if( i++ > 1 ) break;
                resultList.add(music.getIdx());
            }
        }

        int[] result = new int[resultList.size()];

        int i = 0;
        for (Integer integer : resultList) {
            result[i++] = integer;
        }

        return result;

    }


    public static class Music implements Comparable<Music>{

        private int play;
        private int idx;

        public int getPlay() {
            return play;
        }

        public Music setPlay(int play) {
            this.play = play;
            return this;
        }

        public int getIdx() {
            return idx;
        }

        public Music setIdx(int idx) {
            this.idx = idx;
            return this;
        }

        @Override
        public int compareTo(Music o) {
            int result =  o.getPlay() - this.getPlay();
            return result == 0 ? (this.getIdx() - o.getIdx()) : result;

        }

        @Override
        public String toString() {
            return "Music{" +
                    "play=" + play +
                    ", idx=" + idx +
                    '}';
        }
    }


//=======================================================================================================================================

    public int[] solution2(String[] genres, int[] plays) {
        HashMap<String, Object> genresMap = new HashMap<String, Object>();      //<장르, 곡 정보>
        HashMap<String, Integer> playMap = new HashMap<String, Integer>(); //<장르, 총 장르 재생수>
        ArrayList<Integer> resultAL = new ArrayList<Integer>();

        for(int i = 0; i < genres.length; i++){
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>

            if(genresMap.containsKey(key)){
                infoMap = (HashMap<Integer, Integer>)genresMap.get(key);
            }
            else {
                infoMap = new HashMap<Integer, Integer>();
            }

            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);

            //재생수
            if(playMap.containsKey(key)){
                playMap.put(key, playMap.get(key) + plays[i]);
            }
            else {
                playMap.put(key, plays[i]);
            }
        }

        int mCnt = 0;
        Iterator it = sortByValue(playMap).iterator();

        while(it.hasNext()){
            String key = (String)it.next();
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>)genresMap.get(key)).iterator();
            int playsCnt = 0;

            while(indexIt.hasNext()){
                resultAL.add((int)indexIt.next());
                mCnt++;
                playsCnt++;
                if(playsCnt > 1) break;
            }
        }

        int[] answer = new int[resultAL.size()];

        for(int i = 0; i < resultAL.size(); i++){
            answer[i] = resultAL.get(i).intValue();
        }

        return answer;
    }

    private ArrayList sortByValue(final Map map){
        ArrayList<Object> keyList = new ArrayList();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator(){
            public int compare(Object o1, Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return keyList;
    }


    //    ===================================================TEST CASE===========================================================

    public static List<int[]> getResultTestCases(){
        int[] result = {4, 1, 3, 0};

        List<int[]> results = new ArrayList<>();
        results.add(result);

        return results;
    }


    public static List<String[]> getGenresTestCases(){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};

        List<String[]> genresList = new ArrayList<>();
        genresList.add(genres);

        return genresList;
    }

    public static List<int[]> getPlaysTestCases(){
        int[] plays = {500, 600, 150, 800, 2500};

        List<int[]> playsList = new ArrayList<>();
        playsList.add(plays);

        return playsList;
    }
}
