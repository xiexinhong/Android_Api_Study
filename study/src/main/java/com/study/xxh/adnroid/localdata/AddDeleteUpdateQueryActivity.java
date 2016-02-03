package com.study.xxh.adnroid.localdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.study.xxh.adnroid.R;

import java.util.List;

/**
 * Created by xiexinhong on 16/2/2.
 */
public class AddDeleteUpdateQueryActivity extends AppCompatActivity implements View.OnClickListener {


    private ListView mListView;
    private PersonDao mPersonDao;
    private EditText mName;
    private EditText mAge;
    private EditText mPhone;
    private List<Person> mPersons;
    private PersonAdapter mAdapter;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context,AddDeleteUpdateQueryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persion_aduq);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_TITLE | ActionBar.DISPLAY_HOME_AS_UP);
        mActionBar.setTitle("本地数据增删改查");

        mPersonDao = new PersonDao();
        mListView = (ListView) findViewById(R.id.person_list);
        mName = (EditText) findViewById(R.id.name);
        mAge = (EditText) findViewById(R.id.age);
        mPhone = (EditText) findViewById(R.id.phone);
        mAdapter = new PersonAdapter(this);
        mListView.setAdapter(mAdapter);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mPersonDao.delete(mPersons.get(position).id);
                query();
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.add:
                addPerson();
                break;
            case R.id.query:
                query();
                break;
        }
    }

    private void addPerson() {
        Person person = new Person();
        person.name = mName.getText().toString() ;
        person.age = Integer.valueOf(mAge.getText().toString());
        person.phone = mPhone.getText().toString();
        mPersonDao.insert(person);
    }

    private void query() {
        mPersons = mPersonDao.queryAll();
        mAdapter.setData(mPersons);
    }

    class PersonAdapter extends BaseAdapter {

        private List<Person> persons = null;
        private Context mContext;

        public PersonAdapter(Context context) {
            this.mContext = context;
        }

        public void setData(List<Person> persons) {
            this.persons = persons;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return persons != null ? persons.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return persons != null ? persons.get(position) : null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null) {
                convertView = ((LayoutInflater)mContext.getSystemService(LAYOUT_INFLATER_SERVICE)).inflate(R.layout.item_person,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else  {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.bindView(persons.get(position));
            return convertView;
        }

        class ViewHolder {

            TextView mName;
            TextView mAge;
            TextView mPhone;
            View mContent;

            public ViewHolder(View view) {
                mContent = view;
                mName = (TextView) view.findViewById(R.id.item_name);
                mAge = (TextView) view.findViewById(R.id.item_age);
                mPhone = (TextView) view.findViewById(R.id.item_phone);
            }

            public void bindView(Person person) {
                if(person != null) {
                    mName.setText("姓名：" + person.name);
                    mAge.setText("年龄："+person.age);
                    mPhone.setText("电话：" + person.phone);
                }
            }

        }
    }
}
