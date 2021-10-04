//87736, 948
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class algo_1167_박동식_dijkstra {

	static int V;
	static ArrayList<Node>[] graph;
	static int answer = 0;
	static int INF = 1_000_000_001;
	
	public static void main(String args[]) throws IOException {
		// 입출력 도구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		graph = new ArrayList[V+1];
		for(int i=1;i<=V;i++) graph[i] = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			while(to!=-1) {
				int dist = Integer.parseInt(st.nextToken());
				graph[from].add(new Node(to,dist));
				
				to = Integer.parseInt(st.nextToken());
			}
		}
		
		int nodeA = dijkstra(1);
		int nodeB = dijkstra(nodeA);
		
		System.out.println(answer);
		
		}
	
	
	static int dijkstra(int startPoint) {
		int lastNode = startPoint;
		answer = 0;
		int[] distance = new int[V+1];
		for(int i=1;i<=V;i++) distance[i] = INF;
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->(n1.dist-n2.dist));

		distance[startPoint] = 0;
		pq.offer(new Node(startPoint,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int curNodeNum = current.to;
			int curDist = current.dist;
			
			if(distance[curNodeNum]<curDist) continue;
			
			lastNode = curNodeNum;
			answer = curDist;
			
			for(int i=0;i<graph[curNodeNum].size();i++) {
				Node next = graph[curNodeNum].get(i);
				int nextNodeNum = next.to;
				int nextCost = curDist + next.dist;
				
				if(distance[nextNodeNum]>nextCost) {
					distance[nextNodeNum]=nextCost;
					pq.offer(new Node(nextNodeNum,nextCost));
				}
			}

		}
		
		return lastNode;
	}


	static class Node{
		int to;
		int dist;
		
		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}	
	}
}