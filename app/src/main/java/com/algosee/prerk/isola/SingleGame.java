package com.algosee.prerk.isola;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.perk.perksdk.PerkListener;
import com.perk.perksdk.PerkManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleGame extends Fragment {

    View rootView;
    SinglePlayerLogic game1;
    int newx,newy,blockx,blocky;
    String id;
    ImageView IM[] = new ImageView[49];
    int move_block = 0;

    String key = "848bd69a3169a138522c20e22d97c2b6bcbae01a";

    public SingleGame() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_game, container, false);
        game1 = new SinglePlayerLogic();
        game1.init();
        PerkManager.startSession(getContext(), key);

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
        IM[27] = (ImageView) rootView.findViewById(R.id.r3c6);
        IM[28] = (ImageView) rootView.findViewById(R.id.r4c0);
        IM[29] = (ImageView) rootView.findViewById(R.id.r4c1);
        IM[30] = (ImageView) rootView.findViewById(R.id.r4c2);
        IM[31] = (ImageView) rootView.findViewById(R.id.r4c3);
        IM[32] = (ImageView) rootView.findViewById(R.id.r4c4);
        IM[33] = (ImageView) rootView.findViewById(R.id.r4c5);
        IM[34] = (ImageView) rootView.findViewById(R.id.r4c6);
        IM[35] = (ImageView) rootView.findViewById(R.id.r5c0);
        IM[36] = (ImageView) rootView.findViewById(R.id.r5c1);
        IM[37] = (ImageView) rootView.findViewById(R.id.r5c2);
        IM[38] = (ImageView) rootView.findViewById(R.id.r5c3);
        IM[39] = (ImageView) rootView.findViewById(R.id.r5c4);
        IM[40] = (ImageView) rootView.findViewById(R.id.r5c5);
        IM[41] = (ImageView) rootView.findViewById(R.id.r5c6);
        IM[42] = (ImageView) rootView.findViewById(R.id.r6c0);
        IM[43] = (ImageView) rootView.findViewById(R.id.r6c1);
        IM[44] = (ImageView) rootView.findViewById(R.id.r6c2);
        IM[45] = (ImageView) rootView.findViewById(R.id.r6c3);
        IM[46] = (ImageView) rootView.findViewById(R.id.r6c4);
        IM[47] = (ImageView) rootView.findViewById(R.id.r6c5);
        IM[48] = (ImageView) rootView.findViewById(R.id.r6c6);

        display();
        for(int j = 0;j<49;j++) {
            final int i = j;
            IM[j].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newx = i / 7;
                    newy = i % 7;
                    //Toast.makeText(getContext(), newx + " " + newy, Toast.LENGTH_SHORT).show();
                    play();
                }
            });
        }

        return rootView;
    }


    public void display(){
        //Toast.makeText(getContext(),"display",Toast.LENGTH_SHORT).show();
        //int Id[] = {R.id.r0c0,R.id.r0c1,R.id.r0c2,};
        final PerkListener localPerkListener = new PerkListener() {
            @Override
            public void onPerkEvent(String reason) {
                //Toast.makeText(getContext(), reason +";", Toast.LENGTH_SHORT).show();
            }
        };


        for(int i =0;i<7;i++)
            for(int j =0;j<7;j++)
            {
                int idpos= i * 7 + j;
                if(game1.grid[i][j] == 1){
                    IM[idpos].setImageResource(R.drawable.isola1);
                }
                else if(game1.grid[i][j] == 2){
                    IM[idpos].setImageResource(R.drawable.isola2);
                }
                else if(game1.grid[i][j] == -1){
                    IM[idpos].setBackgroundColor(getResources().getColor(R.color.grid_background_blocked));
                }
                else if(game1.grid[i][j] == 0){
                    IM[idpos].setBackgroundColor(getResources().getColor(R.color.grid_background_white));
                    IM[idpos].setImageDrawable(null);
                }
            }
        //IM[0].setImageResource(R.drawable.isola1);
        //IM[1].setImageResource(R.drawable.isola2);
    }


    public void play(){
        //Toast.makeText(getContext(),"play",Toast.LENGTH_SHORT).show();
        if(move_block == 0){
            int check_flag = game1.playerMove(newx, newy);
            if( check_flag == -1) {
                Toast.makeText(rootView.getContext(), "Invalid move", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                display();
                if( check_flag == 1){
                    //Toast.makeText(getContext(),"Player 1 won",Toast.LENGTH_SHORT).show();
                    PerkManager.trackEvent(getContext(), key, "c7c5751718d58d2455313eb7719de5ad54236529", false, null);
                    call_popup_p();

                }
                else if(check_flag == 2){
                    //Toast.makeText(getContext(),"Computer won",Toast.LENGTH_SHORT).show();
                    //PerkManager.trackEvent(getContext(), key,"c7c5751718d58d2455313eb7719de5ad54236529", false, null);
                    call_popup_c();
                }
                move_block = 1;
                //Toast.makeText(getContext(),check_flag+"",Toast.LENGTH_SHORT).show();
            }
        }else if( move_block == 1){
            int check_flag = game1.playerBlock(newx, newy);
            if( check_flag == -2) {
                Toast.makeText(getContext(),"Invalid Block",Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                display();
                //Toast.makeText(getContext(),check_flag+"",Toast.LENGTH_SHORT).show();
                if( check_flag == 1){
                    //Toast.makeText(getContext(),"Player 1 won",Toast.LENGTH_SHORT).show();
                    PerkManager.trackEvent(getContext(), key, "c7c5751718d58d2455313eb7719de5ad54236529", false, null);
                    call_popup_p();
                }
                else if(check_flag == 2){
                    //Toast.makeText(getContext(),"Computer won",Toast.LENGTH_SHORT).show();
                    call_popup_c();
                }
                move_block = 0;
                //Toast.makeText(getContext(),check_flag+"",Toast.LENGTH_SHORT).show();
                game1.compMove();
                display();
                int check_flag1 = game1.compBlock();
                //Toast.makeText(getContext(),check_flag1+"",Toast.LENGTH_SHORT).show();
                display();
                if( check_flag1 == 1){
                    //Toast.makeText(getContext(),"Player won",Toast.LENGTH_SHORT).show();
                    PerkManager.trackEvent(getContext(), key, "c7c5751718d58d2455313eb7719de5ad54236529", false, null);
                    call_popup_p();
                }
                else if(check_flag1 == 2){
                    //Toast.makeText(getContext(),"Computer won",Toast.LENGTH_SHORT).show();
                    call_popup_c();
                }

            }
        }
    }

    public void call_popup_p()
    {
        Context context = getContext();
        LinearLayout viewGroup = (LinearLayout) rootView.findViewById(R.id.pwin);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.pwin_pop, viewGroup);

        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
        popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setFocusable(true);
        //Point p = new Point();
        //p.x = [0];
        //p.y = location[1];
        int OFFSET_X = 50;
        int OFFSET_Y = 320;
        popup.setBackgroundDrawable(new BitmapDrawable());
        //popup.showAsDropDown(layout, 0, 30);

        popup.showAtLocation(layout, Gravity.NO_GRAVITY, OFFSET_X, OFFSET_Y);

        Button b = (Button) layout.findViewById(R.id.closep);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                Fragment fragment = new SingleGame();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
                popup.dismiss();
            }
        });

        Button b1 = (Button) layout.findViewById(R.id.mmp);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
                Intent mainmenu = new Intent(getContext(),Welcome.class);
                startActivity(mainmenu);
                getActivity().finish();
            }
        });



    }

    public void call_popup_c()
    {
        Context context = getContext();
        LinearLayout viewGroup = (LinearLayout) rootView.findViewById(R.id.cwin);
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.cwin_pop, viewGroup);

        final PopupWindow popup = new PopupWindow(context);
        popup.setContentView(layout);
        popup.setWidth(LinearLayout.LayoutParams.FILL_PARENT);
        popup.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popup.setFocusable(true);
        //Point p = new Point();
        //p.x = [0];
        //p.y = location[1];
        int OFFSET_X = 50;
        int OFFSET_Y = 320;
        popup.setBackgroundDrawable(new BitmapDrawable());
        //popup.showAsDropDown(layout, 0, 30);

        popup.showAtLocation(layout, Gravity.NO_GRAVITY, OFFSET_X, OFFSET_Y);

        Button b = (Button) layout.findViewById(R.id.closec);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                Fragment fragment = new SingleGame();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
                popup.dismiss();
            }
        });

        Button b1 = (Button) layout.findViewById(R.id.mmc);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
                Intent mainmenu = new Intent(getContext(),Welcome.class);
                startActivity(mainmenu);
                getActivity().finish();
            }
        });

    }

}
