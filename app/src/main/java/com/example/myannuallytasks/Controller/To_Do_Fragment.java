package com.example.myannuallytasks.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myannuallytasks.R;
import com.example.myannuallytasks.Repasitory.Repasitory_Task;
import com.example.myannuallytasks.model.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class To_Do_Fragment extends Fragment {

    public static final int REQUEST_CODE = 0;
    private  ImageView mBackground;
    private FloatingActionButton mFloatingAction_To_Do;


    private RecyclerView mRecyclerView;
 private TaskAdapter_To_Do mTaskAdapter_To_Do ;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Task> mTasks_To_Do = new ArrayList<>();

    /////////////////////////////////////////
    public To_Do_Fragment() {
        // Required empty public constructor
    }
///////////////////////////////////////////////////////
    public static To_Do_Fragment newInstance() {

        Bundle args = new Bundle();

        To_Do_Fragment fragment = new To_Do_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    /////////////////////////////////////////////
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }
/////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_to__do_, container, false);

        mBackground = view.findViewById(R.id.id_imageView_RecycelerView);
        mFloatingAction_To_Do=view.findViewById(R.id.id_floating_add_todo);
        mRecyclerView=view.findViewById(R.id.id_recyclerview_todo);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        updateUI();

//if(  Repasitory_Task.getInstance().getmTasksToDo().size()>1)
//{mBackground.setVisibility(View.GONE);}
        ////////////////////////Floating Action Button////////
        mFloatingAction_To_Do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getActivity().getSupportFragmentManager();
                AddDialogFragment fragment=new AddDialogFragment();
                fragment.setTargetFragment(To_Do_Fragment.this, REQUEST_CODE);/////////////اضافه کرد مهسسسسسسااااااااااااااااااااااا
                fragment.show(getFragmentManager(), " My Add ");



               // Task task = new Task();
             //  Repasitory_Task.getInstance().insertTask(task);
               // Intent intent = CrimePagerActivity.newIntent(getActivity(), crime.getId());
               // startActivity(intent);
            }
        });

        return view;
    }


//////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.taskmenu, menu);

        MenuItem subtitleItem = menu.findItem(R.id.id_LogOff);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_LogOff:
             Intent intent =new Intent(getActivity(), First_Activity.class);
             startActivity(intent);
                return true;
            default:
        return super.onOptionsItemSelected(item);
    }
}

//////////////////////RecyclerView Section

    public void updateUI() {
        if (mTaskAdapter_To_Do == null) {
            mTasks_To_Do = Repasitory_Task.getInstance().getmTasksToDo();
            mTaskAdapter_To_Do = new TaskAdapter_To_Do (mTasks_To_Do);
            mRecyclerView.setAdapter(mTaskAdapter_To_Do);
        } else {
            mTaskAdapter_To_Do.notifyDataSetChanged();
        }


    }

  
    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUI();
    }

    private class TaskHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewTitle;
        private ImageView mImageViewTask;

        private Task mTask;

        public TaskHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.id_textView_RecycelerView);
            mImageViewTask = itemView.findViewById(R.id.id_imageView_RecycelerView);

  /*          itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = TaskPagerActivity.newIntent(getActivity(), mTask.getId());
                    startActivity(intent);
                }
            });*/
        }

        public void bind(Task Task) {
            mTask = Task;
            mTextViewTitle.setText(Task.getmTitle());
            mImageViewTask.setVisibility( View.VISIBLE);
        }
    }


    private class TaskAdapter_To_Do extends RecyclerView.Adapter<TaskHolder> {

        public static final String TAG = "TaskAdapter";


        public TaskAdapter_To_Do(List<Task> Tasks_ToDo) {
            mTasks_To_Do = Tasks_ToDo;
        }

        @NonNull
        @Override
        public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_layout_recycelerview, parent, false);
            return new TaskHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            holder.bind(mTasks_To_Do.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasks_To_Do.size();
        }
    }
    /////////////////////////End of Recyceler View///////


}
