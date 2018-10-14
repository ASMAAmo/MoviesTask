package movie.app.com.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import movie.app.com.model.MoviModel;
import movie.app.com.model.Result;
import movie.app.com.movies.R;
import movie.app.com.movies.Vediodetails;
import movie.app.com.movies.vediolist;


/**
 * Created by ahmed on 11/18/2017.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>  {

    OnItemClickListener onItemClickListener;
    public static   int num;
    Context context;
    List<Result> faqModels;
    boolean ischecked=false;
    Button btncall;
    ImageView img_book;
    String url="https://image.tmdb.org/t/p/w500/";
        public  String delegateId,userid,serviceid,quat;

    public BooksAdapter(Context context, List<Result> faqModels) {
        this.context = context;
        this.faqModels = faqModels;

    }


    public interface OnItemClickListener {
        void onclick(int position);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.booksitem, parent, false));
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        animate(holder);
        holder.linall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,Vediodetails.class);
                intent.putExtra("Movlist",faqModels.get(position));
                context.startActivity(intent);

            }
        });
        final Result faqModel = faqModels.get(position);

        holder.txtbookname.setText(faqModels.get(position).getTitle());
        //
        Picasso.with(context)
                .load(url + faqModel.getPosterPath()).fit().placeholder(R.drawable.vecrotat).into(holder.img_book);
    }
    @Override
    public int getItemCount() {
        return faqModels.size();
    }

    public void setOnClickListener(OnItemClickListener onClickListener) {
        this.onItemClickListener = onClickListener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btncall;
        ImageView img_book;
        LinearLayout linall;
     TextView txtbookname,txtbookauthor,txtvediodate;
        public ViewHolder(View itemView) {
            super(itemView);
            txtbookname = (TextView) itemView.findViewById(R.id.txtbookname);
            linall=(LinearLayout)itemView.findViewById(R.id.linall);
            img_book=(ImageView)itemView.findViewById(R.id.img_book);
            txtbookauthor = (TextView) itemView.findViewById(R.id.txtbookauthor);}
    }
    public void animate(RecyclerView.ViewHolder viewHolder) {
        final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
        viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    }
}
