import java.util.ArrayList;

public class ImmutableList implements IImmutableList {
	private ArrayList<Integer> data;

	public ImmutableList(int[] numbers) {
		data = new ArrayList<>();
		for (int n : numbers) {
			data.add(n);
		}
	}

	public ImmutableList(IImmutableList clonelist) {
		data = new ArrayList<>();
		for (int x = 0; x < clonelist.size(); x++) {
			data.add(clonelist.get(x));
		}
	}

	@Override
	public int get(int index) {
		return data.get(index);
	}

	@Override
	public IImmutableList concat(IImmutableList list) {
		ImmutableList newList = new ImmutableList(this);
		for(int x = list.size() - 1; x >= 0; x--) {
			newList.data.add(this.size(), list.get(x));
		}
		return newList;
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
