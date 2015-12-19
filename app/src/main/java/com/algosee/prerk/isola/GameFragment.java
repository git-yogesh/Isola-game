package com.algosee.prerk.isola;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    gameLogic game1;
    int newx,newy,blockx,blocky;
    String id;
    ImageView IM[] = new ImageView[49];


    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        game1 = new gameLogic();

        /*Button mButton = (Button) rootView.findViewById(R.id.b1);
        mButton.setTag("sdj");
        LinearLayout l = (LinearLayout) rootView.findViewById(R.id.test);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), v.getTag().toString(), Toast.LENGTH_SHORT).show();

                int a1, a2, a3, a4;
                EditText e1, e2, e3, e4;
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
                int f = game1.game(a1, a2, a3, a4);
                Toast.makeText(getContext(), f + " ", Toast.LENGTH_SHORT).show();


                TextView t1, t2, t3, t4, t5;
                t1 = (TextView) rootView.findViewById(R.id.p1x);
                t2 = (TextView) rootView.findViewById(R.id.p1y);
                t3 = (TextView) rootView.findViewById(R.id.p2x);
                t4 = (TextView) rootView.findViewById(R.id.p2y);
                t5 = (TextView) rootView.findViewById(R.id.gf);

                t1.setText(game1.p1PosX + "");
                t2.setText(game1.p1PosY + "");
                t3.setText(game1.p2PosX + "");
                t4.setText(game1.p2PosY + "");
                t5.setText(f + "");


            }
        });*/

        IM[0] = (ImageView) rootView.findViewById(R.id.r0c0);
        IM[1] = (ImageView) rootView.findViewById(R.id.r0c1);
        IM[2] = (ImageView) rootView.findViewById(R.id.r0c2);
        IM[3] = (ImageView) rootView.findViewById(R.id.r0c3);
        IM[4] = (ImageView) rootView.findViewById(R.id.r0c4);
        IM[5] = (ImageView) rootView.findViewById(R.id.r0c5);
        IM[6] = (ImageView) rootView.findViewById(R.id.r0c6);
        IM[7] = (ImageView) rootView.findViewById(R.id.r1c0);
        IM[8] = (ImageView) rootView.findViewById(R.id.r1c1);
        IM[9] = (ImageView) rootView.findViewById(R.id.r1c2);
        IM[10] = (ImageView) rootView.findViewById(R.id.r1c3);
        IM[11] = (ImageView) rootView.findViewById(R.id.r1c4);
        IM[12] = (ImageView) rootView.findViewById(R.id.r1c5);
        IM[13] = (ImageView) rootView.findViewById(R.id.r1c6);
        IM[14] = (ImageView) rootView.findViewById(R.id.r2c0);
        IM[15] = (ImageView) rootView.findViewById(R.id.r2c1);
        IM[16] = (ImageView) rootView.findViewById(R.id.r2c2);
        IM[17] = (ImageView) rootView.findViewById(R.id.r2c3);
        IM[18] = (ImageView) rootView.findViewById(R.id.r2c4);
        IM[19] = (ImageView) rootView.findViewById(R.id.r2c5);
        IM[20] = (ImageView) rootView.findViewById(R.id.r2c6);
        IM[21] = (ImageView) rootView.findViewById(R.id.r3c0);
        IM[22] = (ImageView) rootView.findViewById(R.id.r3c1);
        IM[23] = (ImageView) rootView.findViewById(R.id.r3c2);
        IM[24] = (ImageView) rootView.findViewById(R.id.r3c3);
        IM[25] = (ImageView) rootView.findViewById(R.id.r3c4);
        IM[26] = (ImageView) rootView.findViewById(R.id.r3c5);
        IM[21] = (ImageView) rootView.findViewById(R.id.r3c6);




        for(int j = 0;j<4;j++) {
            final int i = j;
            IM[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newx = i / 7;
                    newy = i % 7;
                    Toast.makeText(getContext(), newx + " " + newy, Toast.LENGTH_SHORT).show();
                }
            });
        }




        return rootView;
    }

    public void play(View view){
        Toast.makeText(getContext(),id,Toast.LENGTH_SHORT).show();
    }


}
