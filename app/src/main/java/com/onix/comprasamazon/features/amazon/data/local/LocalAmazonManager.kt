import com.onix.comprasamazon.core.exceptions.gateway.GatewayException
import com.onix.comprasamazon.core.exceptions.gateway.TypeGatewayException
import com.onix.comprasamazon.core.utilities.Either
import com.onix.comprasamazon.features.amazon.data.local.room.DAOAmazon
import com.onix.comprasamazon.features.amazon.data.local.room.RoomAmazon
import com.onix.comprasamazon.features.amazon.domain.business.entities.BaseAmazon
import com.onix.comprasamazon.features.amazon.domain.infraestructure.AmazonGateway
import javax.inject.Inject

class LocalAmazonManager @Inject constructor(private val daoAmazon: DAOAmazon):AmazonGateway{

    private var error : GatewayException=GatewayException(TypeGatewayException.UnKnow,mapOf<String, String>("descripcion" to "error desconocido"),"",Throwable())

    override suspend fun editAmazon(amazon: BaseAmazon): Either<GatewayException, Boolean> {
        var rEither: Either<GatewayException, Boolean>
        try {
            if(daoAmazon.update(RoomAmazon.baseToRoom(amazon))!=0){
                rEither = Either.right(true)
            }else{
                error= GatewayException(
                    TypeGatewayException.UnKnow,
                    mapOf<String, String>("descripcion" to "error desconocido"),
                    "",
                    Throwable())
                rEither = Either.left(error)

            }
        }catch (e:Exception){
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("descripcion" to e.message.toString()),
                e.message.toString(),
                e
            )
            rEither=Either.left(error)
        }

        return rEither
    }

    override suspend fun getAmazon(): Either<GatewayException, BaseAmazon> {
        var rEither: Either<GatewayException, BaseAmazon>
        try {
            val amazonGot=daoAmazon.getAll()
            if(amazonGot.id>=0L){
                rEither = Either.right(amazonGot)
            }else{
                error= GatewayException(
                    TypeGatewayException.UnKnow,
                    mapOf<String, String>("descripcion" to "error desconocido"),
                    "",
                    Throwable()
                )
                rEither = Either.left(error)

            }
        }catch (e:Exception){
            error = GatewayException(
                TypeGatewayException.UnKnow,
                mapOf<String, String>("descripcion" to e.message.toString()),
                e.message.toString(),
                e
            )
            rEither=Either.left(error)
        }

        return rEither
    }

}