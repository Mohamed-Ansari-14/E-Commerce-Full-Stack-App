package com.app.eCommerce.services.admin.faq;

import com.app.eCommerce.dto.FAQDto;

public interface FAQService {

	FAQDto postFAQ(Long productId, FAQDto faqDto);
}
