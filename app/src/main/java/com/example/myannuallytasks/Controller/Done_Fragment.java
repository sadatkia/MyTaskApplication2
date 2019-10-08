package com.example.myannuallytasks.Controller;



import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
public class Done_Fragment extends Fragment {
    public static final int REQUEST_CODE1 = 1;
    private  ImageView mBackground;
    private FloatingActionButton mFloatingAction_Done;

    private RecyclerView mRecyclerView;
    private TaskAdapter_Done mTaskAdapter_Done ;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Task> mTasksDone= Repasitory_Task.getInstance().getmTasksDone();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Done_Fragment() {
        // Required empty public constructor
    }
////////////////////////
public static Done_Fragment newInstance() {
    
    Bundle args = new Bundle();
    
    Done_Fragment fragment = new Done_Fragment();
    fragment.setArguments(args);
    return fragment;
}
//////////////////////////////////////////////////////
@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setHasOptionsMenu(true);
}
 ///////////////////////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_done_, container, false);
       // mBackground = view.findViewById(R.id.id_background_done);
        mFloatingAction_Done=view.findViewById(R.id.id_floating_add_done);
        mRecyclerView=view.findViewById(R.id.id_recyclerview_done);


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);


        updateUI_Done();

        ////////////////////////Floating Action Button////////
        mFloatingAction_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                getActivity().getSupportFragmentManager();
                AddDialogFragment fragment=new AddDialogFragment();
                fragment.setTargetFragment(Done_Fragment.this, REQUEST_CODE1);/////////////اضافه کرد مهسسسسسسااااااااااااااااااااااا

                fragment.show(getFragmentManager(), " My Add ");
            }
        });



        return  view;
    }
/////////////////////////////////////////////////Log Off Section//////////////////////
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
    ////////////////////////

    public void updateUI_Done() {
        if (mTaskAdapter_Done == null) {
            mTaskAdapter_Done = new TaskAdapter_Done (mTasksDone);
            mRecyclerView.setAdapter(mTaskAdapter_Done);
        } else {
            mTaskAdapter_Done.notifyDataSetChanged();
        }


    }


    @Override
    public void onResume() {
        super.onResume();
        updateUI_Done();
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUI_Done();
    }


///////////////////////////////////////////////////////////////////////Recyclere View Section///////////////
    private class TaskHolderDone extends RecyclerView.ViewHolder {
        private TextView mTextViewTitle;
        // private TextView mTextViewDate;
        private ImageView mImageViewTask;

        private Task mTask;

        public TaskHolderDone(@NonNull View itemView) {
            super(itemView);

            mTextViewTitle = itemView.findViewById(R.id.id_textView_RecycelerView);
            // mTextViewDate = itemView.findViewById(R.id.txtview_list_item_date);
            mImageViewTask = itemView.findViewById(R.id.id_imageView_RecycelerView);

     /*       itemView.setOnClickListener(new View.OnClickListener() {
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
            //mTextViewDate.setText(Task.getDate().toString());
            // mImageViewTask.setVisibility();
        }
    }

    private class TaskAdapter_Done extends RecyclerView.Adapter<TaskHolderDone> {

        public static final String TAG = "TaskAdapter";


        public TaskAdapter_Done(List<Task> Tasks) {
            mTasksDone = Tasks;
        }

        public void setTasks(List<Task> Tasks) {
            mTasksDone = Tasks;
        }

        @NonNull
        @Override
        public TaskHolderDone onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder");
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.item_layout_recycelerview, parent, false);
            return new TaskHolderDone(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskHolderDone holder, int position) {
            Log.d(TAG, "onBindViewHolder");
            holder.bind(mTasksDone.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasksDone.size();
        }
    }

    ///////////////////End Of Recyceler View Section/////////////////////////////////////////////
}
