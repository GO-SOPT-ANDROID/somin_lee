import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.android.go.sopt.R
import org.android.go.sopt.model.ResponseListUserDto

class GridAdapter(private val context: Context, private val userList: List<ResponseListUserDto.ListUserData>) : BaseAdapter() {

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): ResponseListUserDto.ListUserData {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder: ViewHolder
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val user = getItem(position)
        viewHolder.bind(user)

        return view
    }

    private class ViewHolder(view: View) {
        private val imageView: ImageView = view.findViewById(R.id.ivUser)
        private val nameTextView: TextView = view.findViewById(R.id.tvUserName)
        private val emailTextView: TextView = view.findViewById(R.id.tvUserEmail)

        fun bind(user: ResponseListUserDto.ListUserData) {
        }
    }
}
