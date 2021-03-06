package org.metabrainz.mobile.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.metabrainz.mobile.App;
import org.metabrainz.mobile.R;
import org.metabrainz.mobile.view.HtmlAssetTextView;

public class AboutFragment extends Fragment {

    private TextView versionLabel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_about, container);
        versionLabel = (TextView) layout.findViewById(R.id.version_text);
        HtmlAssetTextView body = (HtmlAssetTextView) layout.findViewById(R.id.about_text);
        body.setAsset("about.html");
        return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        versionLabel.setText(getText(R.string.version_text) + " " + App.getVersion());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_about, menu);
    }

}
