package com.algosee.prerk.isola;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    gameLogic game1;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        game1 = new gameLogic();

        Button mButton = (Button) rootView.findViewById(R.id.b1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1,a2,a3,a4;
                EditText e1,e2,e3,e4;
                e1 = (EditText) rootView.findViewById(R.id.newx);
                e2 = (EditText) rootView.findViewById(R.id.newy);
                e3 = (EditText) rootView.findViewById(R.id.blockx);
                e4 = (EditText) rootView.findViewById(R.id.blocky);

                a1 = Integer.parseInt(e1.getText().toString());
                a2 = Integer.parseInt(e2.getText().toString());
                a3 = Integer.parseInt(e3.getText().toString());
                a4 = Integer.parseInt(e4.getText().toString());

                //Toast.makeText(getContext(),a1+" " +a2+" "+a3 + " " + a4,Toast.LENGTH_SHORT).show();
                game1.init();
                int f = game1.game(a1,a2,a3,a4);
                Toast.makeText(getContext(),f+" ",Toast.LENGTH_SHORT).show();


                TextView t1,t2,t3,t4,t5;
                t1 = (TextView) rootView.findViewById(R.id.p1x);
                t2 = (TextView) rootView.findViewById(R.id.p1y);
                t3 = (TextView) rootView.findViewById(R.id.p2x);
                t4 = (TextView) rootView.findViewById(R.id.p2y);
                t5 = (TextView) rootView.findViewById(R.id.gf);

                t1.setText(game1.p1PosX+"");
                t2.setText(game1.p1PosY+"");
                t3.setText(game1.p2PosX+"");
                t4.setText(game1.p2PosY+"");
                t5.setText(f+"");



            }
        });


        return rootView;
    }


}
