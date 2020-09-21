package com.example.hphilippe_di_tp3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoFragment extends Fragment {

    private String parametre1, legende;
    private View view;
    private ImageView photosVue;
    private TextView textFilename, textLegende;

    private static final String ARG_PARAM1 = "message1";

    public PhotoFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PhotoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoFragment newInstance(String param1) {
        PhotoFragment fragment = new PhotoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            parametre1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        GalerieImages activity = (GalerieImages) getActivity();
        String myIdActivity = activity.getMyIdVignette();

        view = inflater.inflate(R.layout.fragment_photo, container, false);
        textFilename = (TextView) view.findViewById(R.id.textFilename);
        textLegende = (TextView) view.findViewById(R.id.textLegende) ;
        photosVue = (ImageView) view.findViewById(R.id.fragmentImageView);

        switch (myIdActivity){
            case "1":
                legende = "Mésanges";
                break;

            case "2":
                legende = "Pintades";
                break;

            case "3":
                legende = "Coquelicots";
                break;

            case "4":
                legende = "Kayak";
                break;

            case "5":
                legende = "Route";
                break;

            case "6":
                legende = "Forêt";
                break;

            case "7":
                legende = "Plage";
                break;

            case "8":
                legende = "Pissenlit";
                break;

            case "9":
                legende = "Pelican";
                break;

            case "10":
                legende = "Blé";
                break;

            case "11":
                legende = "Fleurs1";
                break;

            case "12":
                legende = "Fleurs2";
                break;

            case "13":
                legende = "Mer rouge";
                break;

            case "14":
                legende = "Soleil couchant";
                break;

            case "15":
                legende = "Grenade";
                break;

            case "16":
                legende = "Montagne";
                break;

            case "17":
                legende = "Fourmi";
                break;

            case "18":
                legende = "Grenouille";
                break;

            case "19":
                legende = "Phare";
                break;

            case "20":
                legende = "Flamants roses";
                break;

            default:
                legende = "Photos sans légende";
                break;
        }

        textFilename.setText(parametre1);
        textLegende.setText(legende);

        String stringPath = String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)+ parametre1);

        Bitmap myBitmap = BitmapFactory.decodeFile(stringPath);
        photosVue.setImageBitmap(myBitmap);
        return view;
    }
}