package gov.polisen.ainappen;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ContactsFragment extends Fragment{

	private ListView testList;

	public ContactsFragment() {
		// Empty constructor required for fragment subclasses
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

		testList = (ListView)rootView.findViewById(R.id.listPhone);

		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(new Contact("Peter","polis","112"));
		contactList.add(new Contact("Adolf","befäl","114114"));
		contactList.add(new Contact("Jocke","sopa","000000"));
		ContactListAdapter adapter = new ContactListAdapter(getActivity(), contactList);
		testList.setAdapter(adapter);

		return rootView;
	}
}
