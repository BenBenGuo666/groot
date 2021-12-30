package groot.shiro.demo.aig;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc
 * @Author GuoBen~
 * @Date 2021/12/21
 */
public class CarFleet {

    public static void main(String[] args) {
        /*int target = 100;
        int[] pos = {0, 2, 4};
        int[] sp = {4, 2, 1};
        System.out.println(carFleet(target, pos, sp));*/
    }

    public int s(String a, String b){
        if(a.contains(b)){
            return 1;
        }
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int i = 0;
        int j = 0;
        boolean bool = false;
        while(true){
            if(j >= charA.length){
                if(!bool) break;
                j = 0;
            }
            if(i > charA.length * 2){
                break;
            }
            if(i >= charB.length){ break; }
            if(charB[i] == charA[j]){
                i ++;
                bool = true;
            }else{
                if(bool){
                    if(i > 0 && charA[j] == charB[i - 1]){
                        j ++;
                        continue;
                    }else{
                        bool = false;
                        break;
                    }
                }
                bool = false;
            }
            j ++;
        }
        int count = 1;
        if(bool){
            count ++;
            String apendA = a + a;
            while(true){
                if(apendA.contains(b)){
                    break;
                }
                apendA = apendA + a;
                count ++;
            }
        }
        else{
            return -1;
        }
        return count;
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int result = 0;
        int count = position.length;
        int[] joinPos = new int[count];
        int joinPosLength = 0;
        Map<Integer, Integer> cache = new HashMap<>(count * 2);
        while (count > 0) {
            cache.clear();
            for (int i = 0; i < position.length; i++) {
                boolean skip = false;
                boolean isJoin = false;
                int j = 0;
                for (; j < joinPosLength; j++) {
                    //跳过到达车队或加入车辆
                    if (joinPos[j] == i) {
                        skip = true;
                        j++;
                        break;
                    }
                }
                if (skip) continue;
                //求新的位置
                int nPos = position[i] + speed[i];
                //车队到达
                if (nPos >= target && !isJoin) {
                    joinPos[joinPosLength] = i;
                    joinPosLength++;
                    count--;
                    //终点加入车队
                    if (cache.get(nPos) == null) {
                        boolean isJoinP = false;
                        //是否途径
                        for (Integer k : cache.keySet()) {
                            if(nPos < k){
                                if(position[i] >= cache.get(k)){
                                    //加入车队
                                    isJoinP = true;
                                    break;
                                }
                            }
                        }
                        cache.put(nPos, position[i]);
                        //车队到达
                        if(!isJoinP) result++;
                    }
                } else if (cache.get(nPos) == null) {
                    boolean isJoinP = false;
                    //是否途径
                    for (Integer k : cache.keySet()) {
                        if(nPos < k){
                            if(position[i] >= cache.get(k)){
                                //加入车队
                                joinPos[joinPosLength] = i;
                                joinPosLength++;
                                count--;
                                isJoinP = true;
                                break;
                            }
                        }
                    }
                    if(!isJoinP) cache.put(nPos, position[i]);
                } else {
                    //加入车队
                    joinPos[joinPosLength] = i;
                    joinPosLength++;
                    count--;
                }
                position[i] = nPos;
            }
        }
        return result;
    }

}
