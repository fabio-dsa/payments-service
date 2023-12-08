package br.com.saborexpress.payments.presentation.api.v1.openapi;

import br.com.saborexpress.payments.presentation.api.v1.dto.PaymentDTO;
import br.com.saborexpress.payments.presentation.api.v1.dto.page.CustomPage;
import br.com.saborexpress.payments.presentation.api.v1.dto.request.PaymentRequestDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Pageable;

@OpenAPIDefinition(
        info = @Info(
                title = "Payments - Payment Management",
                version = "V1"
        )
)
public interface PaymentOpenApi {

    @Operation(
            summary = "Find all payments",
            description = "Returns all payments (paginated)",
            tags = {"payments", "list"},
            responses = @ApiResponse(responseCode = "200", description = "Successful operation")
    )
    CustomPage<PaymentDTO> findAll(@Parameter Pageable pageable);

    @Operation(
            summary = "Find payment by id",
            description = "Returns a single payment based on id",
            tags = {"payments"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation", useReturnTypeSchema = true),
                    @ApiResponse(responseCode = "404", description = "Invalid/non-existent payment id")
            }
    )
    PaymentDTO findById(@Parameter(description = "Payment id to be found") String id);

    @Operation(
            summary = "Create a new payment",
            description = "Create a new payment with data provided",
            tags = {"payments"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid payment details")
            }
    )
    void create(PaymentRequestDTO payment);

    @Operation(
            summary = "Confirm a payment",
            description = "Confirm a payment using the id provided",
            tags = {"payments"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid operation")
            }
    )
    void confirm(String id);

    @Operation(
            summary = "Cancel payment",
            description = "Cancel a payment using the id provided",
            tags = {"payments"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid operation")
            }
    )
    void cancel(String id);
}
