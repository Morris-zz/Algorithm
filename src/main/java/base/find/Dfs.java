package base.find;

import base.BaseFindAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * DFS
 * @Author: morris
 * @Date: 2020/8/4 9:24
 * @reviewer
 */
public class Dfs extends BaseFindAlgorithm {

    @Override
    public void find() {

    }

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] indegrees = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }
            // Get the indegree and adjacency of every course.
            for(int[] cp : prerequisites) {
                indegrees[cp[0]]++;
                adjacency.get(cp[1]).add(cp[0]);
            }
            // Get all the courses with the indegree of 0.
            for(int i = 0; i < numCourses; i++) {
                if(indegrees[i] == 0) {
                    queue.add(i);
                }
            }
            // BFS TopSort.
            while(!queue.isEmpty()) {
                int pre = queue.poll();
                numCourses--;
                for(int cur : adjacency.get(pre)) {
                    if(--indegrees[cur] == 0) {
                        queue.add(cur);
                    }
                }
            }
            return numCourses == 0;
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[2][2];

    }

    class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjacency = new ArrayList<>();
            for(int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }
            int[] flags = new int[numCourses];
            for(int[] cp : prerequisites) {
                adjacency.get(cp[1]).add(cp[0]);
            }
            for(int i = 0; i < numCourses; i++) {
                if(!dfs(adjacency, flags, i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            if(flags[i] == 1) {
                return false;
            }
            if(flags[i] == -1) {
                return true;
            }
            flags[i] = 1;
            for(Integer j : adjacency.get(i)) {
                if(!dfs(adjacency, flags, j)) {
                    return false;
                }
            }
            flags[i] = -1;
            return true;
        }
    }



}
