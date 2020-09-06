package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TestClasssss {
	private List<GraphNode> nodes;
	private static int parkingFee;

	public static void main(String[] args) {
		TestClasssss tc = new TestClasssss();
		tc.nodes = new ArrayList<GraphNode>();

		Scanner s = new Scanner(System.in);
		String nmf = s.nextLine();
		String[] startingInputs = nmf.split(" ");
		int nodes = Integer.parseInt(startingInputs[0]);
		int edges = Integer.parseInt(startingInputs[1]);
		parkingFee = Integer.parseInt(startingInputs[2]);
		String[] capacity = s.nextLine().split(" ");
		IntStream.range(0, nodes).forEach(i -> {
			GraphNode n = new GraphNode(Integer.parseInt(capacity[i]));
			tc.nodes.add(n);
		});

		for (int i = 0; i < edges; i++) {
			String[] edgeInfo = s.nextLine().split(" ");
			int source = Integer.parseInt(edgeInfo[0]);
			int target = Integer.parseInt(edgeInfo[1]);
			int cost = Integer.parseInt(edgeInfo[2]);
			Edge e = new Edge();
			GraphNode sourceNode = tc.nodes.get(source - 1);
			sourceNode.getEdges().add(e);
			e.setTarget(tc.nodes.get(target - 1));
			e.getTarget().addcost(sourceNode.getCostFromNode() + cost);
		}

		GraphNode first = tc.nodes.get(0);
		first.update();
		int cars = Integer.parseInt(s.nextLine());

		// population done
		// first car always goes to first node
		first.setCapacity(first.getCapacity() - 1);
		print(first);
		for (int i = 1; i < cars; i++) {
			if (first.getCapacity() > 0) {
				first.setCapacity(first.getCapacity() - 1);
				print(first);
			} else {
				tc.loop(first);
			}
		}

	}

	private void loop(GraphNode src) {
		for (GraphNode n : src.getAllcosts()) {
			if (n.getCapacity() > 0) {
				n.setCapacity(n.getCapacity() - 1);
				print(n);
				return;
			}
		}

	}

	private static void print(GraphNode node) {
		System.out.print(node.getCostFromNode() + parkingFee);
		System.out.print(" ");
	}

}

class Edge {
	private int weight;
	private GraphNode target;

	public final int getWeight() {
		return weight;
	}

	public final void setWeight(int weight) {
		this.weight = weight;
	}

	public final GraphNode getTarget() {
		return target;
	}

	public final void setTarget(GraphNode target) {
		this.target = target;
	}

}

class GraphNode implements Comparable<GraphNode> {

	private int capacity;
	private int costFromNode = 0;
	private List<GraphNode> allcosts = new ArrayList<GraphNode>();
	private List<Edge> edges;

	public GraphNode(int w) {
		capacity = w;
		edges = new ArrayList<Edge>();
	}

	public void update() {
		for (Edge e : edges) {
			if (e.getTarget().getEdges().size() > 0) {
				e.getTarget().update();
			}
			allcosts.add(e.getTarget());
		}

	}

	public void addcost(int cost) {
		costFromNode = costFromNode + cost;
	}

	public final int getCapacity() {
		return capacity;
	}

	public final void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public final List<Edge> getEdges() {
		return edges;
	}

	public final void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public final int getCostFromNode() {
		return costFromNode;
	}

	public final void setCostFromNode(int costFromNode) {
		this.costFromNode = costFromNode;
	}

	public final List<GraphNode> getAllcosts() {
		return allcosts;
	}

	public final void setAllcosts(List<GraphNode> allcosts) {
		this.allcosts = allcosts;
	}

	@Override
	public int compareTo(GraphNode o) {
		return o.getCostFromNode() - this.getCostFromNode();
	}

}
