package com.example.agath.eseoapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by agath on 09/11/2016.
 */

public class RSSAdapter extends RecyclerView.Adapter<RSSAdapter.ArticleViewHolder> implements HTMLAsyncTask.DocumentConsumer{
    private Document _document = null;

    @Override
    public int getItemCount(){
        if(_document != null)
            return _document.select("div.newsContainer").size();
        else
            return 0;
    }

    @Override public  ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position){
        Element item = (Element) _document.select("div.newsContainer").get(position);
        holder.setElement(item);
    }

    @Override
    public void setHTMLDocument(Document document){
        _document = document;
        notifyDataSetChanged();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder{
        private final TextView _title;
        private Element _currentElement;

        public ArticleViewHolder(final View itemView){
            super(itemView);
            _title = ((TextView) itemView.findViewById(R.id.title_view));
        }
        public void setElement(Element element){
            _currentElement = element;
            Elements content = _document.select("div.newsContainer");
        }
    }
}
