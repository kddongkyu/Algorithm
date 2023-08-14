class Solution {

    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 5};
        solution(arr,7);
    }

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        int[] result = {0,sequence.length};
        while (left != sequence.length && right != sequence.length) {
            if(sum < k) {
                sum += sequence[++right];
            } else if(sum > k) {
                sum -= sequence[left++];
            }else {
                if(right - left < result[1]-result[0]) {
                    result[0] = left;
                    result[1] = right;
                    if(right==sequence.length-1) {
                        sum += sequence[++right];
                    }
                }
            }
        }
        return result;
    }
}