package com.letsdecode.problems.graph.edgeweighted;

public class Edge {

	private Vertex v;
	private Vertex w;
	private double weight;

	public Edge(Vertex v, Vertex w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((w == null) ? 0 : w.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (w == null) {
			if (other.w != null)
				return false;
		} else if (!w.equals(other.w))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}

	public Vertex either() {
		return v;
	}

	public int compare(Edge that) {
		if (this.weight < that.weight) {
			return -1;
		} else if (this.weight > that.weight) {
			return 1;
		}
		return 0;
	}

	public Vertex other(String id) {
		if (v.id.equals(id)) {
			return w;
		} else if (w.id.equals(id)) {
			return v;
		}
		throw new RuntimeException("Inconsistent edge");
	}

}
