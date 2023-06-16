import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T // 함수 타입 별칭을 Inflate<T>로 정의

/**BaseFragment 클래스의 생성자에 inflate 매개변수가 추가되었습니다. 이 매개변수는 Inflate<VB> 타입으로 받고, 프래그먼트의 뷰를 인플레이션하는 데 사용됩니다. 이를 통해 BaseFragment 클래스를 상속받을 때 inflate 함수를 직접 지정할 수 있습니다. 또 주어진 코드에서는 VB라는 타입 매개변수를 도입하였습니다. 이는 ViewBinding의 하위 클래스인 바인딩 클래스 타입을 나타냅니다. 이렇게 함으로써 BaseFragment를 상속받을 때, 특정한 바인딩 클래스를 사용하도록 타입을 제한할 수 있습니다.*/
abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}