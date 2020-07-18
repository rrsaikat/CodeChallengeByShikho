package com.rtchubs.filmadmin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rezwan.codechallengebyshikho.GetUserByIdQuery
import com.rezwan.codechallengebyshikho.R


class UserListAdapter(list: List<GetUserByIdQuery.User>, val projectClickListener: (GetUserByIdQuery.User) -> Unit) :
    BaseRecyclerAdapter<GetUserByIdQuery.User, UserListAdapter.ProjectViewHolder>(list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProjectViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_user,
            parent,
            false
        )
    )

    inner class ProjectViewHolder(containerView: View) : BaseViewHolder<GetUserByIdQuery.User>(containerView) {
        internal var p_user: TextView

        init {
            p_user = itemView.findViewById(R.id.userName)

            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    projectClickListener(items[adapterPosition])
                }

            })
        }

        override fun bind(item: GetUserByIdQuery.User) {
            item.username?.let {
                p_user.text = it
            }
        }
    }
}