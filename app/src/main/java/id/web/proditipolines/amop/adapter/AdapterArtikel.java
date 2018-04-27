package id.web.proditipolines.amop.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import id.web.proditipolines.amop.R;
import id.web.proditipolines.amop.activity.DetailArtikelActivity;
import id.web.proditipolines.amop.model.DataArtikel;

import static id.web.proditipolines.amop.util.AppConstans.TAG_ARTIKEL;
import static id.web.proditipolines.amop.util.Helper.KonversiTanggal;

public class AdapterArtikel extends BaseAdapter {
    private Activity activity;
    private List<DataArtikel> items;

    public AdapterArtikel(Activity activity, List<DataArtikel> items) {
        this.activity = activity;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int location) {
        return items.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_row_artikel, null);

        TextView title = (TextView) convertView.findViewById(R.id.txtTitle);
        TextView desc = (TextView) convertView.findViewById(R.id.txtDesc);
        TextView tanggal = (TextView) convertView.findViewById(R.id.txtTanggal);
        TextView nama = (TextView) convertView.findViewById(R.id.txtNamaPegawai);
        final DataArtikel dataHistory = items.get(position);
        title.setText(dataHistory.getNama_artikel());
        desc.setText(dataHistory.getTeks_artikel());
        tanggal.setText(KonversiTanggal(dataHistory.getWaktu_artikel()));
        nama.setText(dataHistory.getNama_pegawai());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(activity, DetailArtikelActivity.class);
                pindah.putExtra(TAG_ARTIKEL, dataHistory);
                activity.startActivity(pindah);
            }
        });
        return convertView;
    }
}
