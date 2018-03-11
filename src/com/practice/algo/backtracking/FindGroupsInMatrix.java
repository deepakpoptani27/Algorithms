package com.practice.algo.backtracking;



public class FindGroupsInMatrix {

	void findGroupsInMatrix(int a[][], int m, int n) {
		
		int sol[][] = new int[m][n];
		intialiseSolution(sol, m, n);
		int groupNo= 1;
		
		
		for(int i = 0;i < m ; i++) {
			for (int j = 0; j< n ; j++) {
				if(sol[i][j] ==0 && solveMatrix(a, m, n, i, j, sol, groupNo)) {
					groupNo++;
				}
			}
		}
		
		for(int i = 0;i < m ; i++) {
			for (int j = 0; j< n ; j++) {
				System.out.print(sol[i][j]+" ");
				}
			System.out.println();
			}
		}
	
	
	boolean solveMatrix(int a[][], int m, int n, int i , int j , int sol[][], int groupNo) {
		
		if(a[i][j] == 0) {
			sol[i][j] = 0;
			return false;
		}else {
			sol[i][j] = groupNo;
		}
		if( i > 0 && sol[i-1][j] ==0 && solveMatrix(a, m, n, i-1, j, sol, groupNo))  // move up
			return true;
		
		if( i < m-1 && sol[i+1][j] ==0 && solveMatrix(a, m, n, i+1, j, sol, groupNo)) // move down
			return true;
		
		if( j > 0 && sol[i][j-1] ==0 && solveMatrix(a, m, n, i, j-1, sol, groupNo)) // move left
			return true;
		if( j < n-1 && sol[i][j+1] ==0 && solveMatrix(a, m, n, i, j+1, sol, groupNo)) // move right
			return true;
		return true;
	}
	
	
	void intialiseSolution(int sol[][], int m, int n ) {
		for(int i = 0;i < m ; i++) {
			for (int j = 0; j< n ; j++) {
				sol[i][j] = 0;
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		FindGroupsInMatrix findGroupsInMatrix = new FindGroupsInMatrix();
		
		int arr[][]={{1,1,0},{1,1,0},{0,0,1}};
		
		findGroupsInMatrix.findGroupsInMatrix(arr, 3, 3);

	}

}
